package generatePatternDatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatternDBSlidingSquareTrieTest {

	@Test
	public void test() {
		int[]availableValues=new int[]{1,2,3,4,5,7,8,9,0};
        
		PatternDBSlidingSquareCollection trie=new PatternDBSlidingSquareCollection(availableValues, (byte)4, (byte)4);
		byte[] vals=new byte[]{6, 6, 6, 6, 6, 0, 2, 3, 4, 1, 5, 9, 6, 6, 7, 8};
		int b=trie.getIndex(vals);
		byte [] vals2=trie.toBytes(b);
		assertArrayEquals(vals, vals2);

	}
	/*@Test
	public void test3() {
    	int[] availableValues={0,1,2,3,4,5,7,8};

		PatternDBSlidingSquareCollection trie=new PatternDBSlidingSquareCollection(availableValues, (byte)4, (byte)4);
		byte[] vals={1,2,3,4,5,6,6,6,7,6,6,6,8,6,6,0};

 		int b=trie.getIndex(vals);
		byte [] vals2=trie.toBytes(b);
		assertArrayEquals(vals, vals2);


	}*/

}
