package generatePatternDatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatternDBSlidingSquareTrieTest {

	@Test
	public void test() {
    	int[] availableValues={0,1,2,3,4,5,7,8};

		PatternDBSlidingSquareCollection trie=new PatternDBSlidingSquareCollection(availableValues, (byte)4, (byte)4);
		byte[] vals={1,2,3,4,5,6,6,6,7,6,6,6,8,6,6,0};

 		int b=trie.getIndex(vals);
		byte [] vals2=trie.toBytes(b);
		assertArrayEquals(vals, vals2);

	}

}
