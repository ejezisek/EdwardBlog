package generatePatternDatabase;


import java.util.ArrayDeque;
import java.util.Queue;

import ed.util.algorithms.Action;

public class NineSquareMain {

    public static  Boolean BFS(PatternDBSlidingSquareNode head, Action<PatternDBSlidingSquareNode, Boolean> action, int[] availableValues)
    {
    	Queue<Integer> q=new ArrayDeque<Integer>();
    	PatternDBSlidingSquareTriePrototype flyweight=new PatternDBSlidingSquareTriePrototype(head.getHeight(), head.getWidth(), availableValues);
    	flyweight.add(head.getSquares(), (byte) head.getNumInRoute());
    	PatternDBSlidingSquareCollection trie=flyweight.getTrie();
    	q.add(trie.getIndex(head.getSquares()));
    	int distance=0;
    	while(true)
    	{
    		if(q.isEmpty())
    		{
    			break; 
    		}
    		PatternDBSlidingSquareNode currentNode=new PatternDBSlidingSquareNode(q.poll(), flyweight);
    		action.performAction(currentNode);
    		if(action.complete())
    			return action.getValue();
    		for(PatternDBSlidingSquareNode val:currentNode.getChildren())
    		{
    			if(val.getNumInRoute()!=distance)
    			{
    				distance=val.getNumInRoute();
    				System.out.println(distance);
    			}
    			if(!flyweight.exists(val.getSquares()))
    			{
    				flyweight.add(val.getSquares(), (byte)val.getNumInRoute());
    		    	q.add(trie.getIndex(val.getSquares()));
    			}
    		}
    	}
		String filename = "/home/edward/Research/generatePatternDBFiles/9Squareresults.out";
    	flyweight.write(filename);
    	return action.getValue();
    }
    static long index=0;

	public static void main(String[] args) {

		byte[] vals={1,2,3,4,5,6,7,8,0};
		int [] availableValues={1,2,3,4,5,6,7,8,0};

		PatternDBSlidingSquareUsingLong startingPos=new PatternDBSlidingSquareUsingLong((byte)3,(byte)3, vals);
		System.out.println(startingPos);
		PatternDBSlidingSquareNode pdssn=new PatternDBSlidingSquareNode(startingPos);
	//	System.out.println(startingPos);
		Action<PatternDBSlidingSquareNode, Boolean> action=new Action<PatternDBSlidingSquareNode, Boolean>()
		{
			int i=0;
			@Override
			public void performAction(PatternDBSlidingSquareNode node) {
				if(i++%1000000==0)
					System.out.println(i);
			}

			@Override
			public boolean complete() {
				return false;
			}

			@Override
			public Boolean getValue() {
				return null;
			}

		};
		NineSquareMain.BFS(pdssn, action, availableValues);
	}

}
