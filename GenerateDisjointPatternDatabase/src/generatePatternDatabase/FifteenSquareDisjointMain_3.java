package generatePatternDatabase;


import java.io.IOException;

import ed.util.algorithms.Action;

public class FifteenSquareDisjointMain_3 {


    static long index=0;

	public static void main(String[] args) throws IOException {
		System.out.println(Runtime.getRuntime().totalMemory());
		byte[] vals={6,6,6,6,
					6,1,2,3,
					6,4,5,9,
					6,7,8,0};
		//		byte[] vals={1,2,3,4,5,6,7,8,0};

    	int[] availableValues={1,2,3,4,5,7,8,9,0};

		PatternDBSlidingSquareUsingLong startingPos=new PatternDBSlidingSquareUsingLong((byte)4,(byte)4, vals, availableValues);
		System.out.println(startingPos);
		PatternDBSlidingSquareNode pdssn=new PatternDBSlidingSquareNode(startingPos);
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
		String filename = FifteenSquareDisjointMain_1.defaultFileDir+"/15Squareresults_disjoint_3.out";
		FifteenSquareBFS.BFS(pdssn, action, availableValues, filename);
		System.out.println("Complete");
	}

}
