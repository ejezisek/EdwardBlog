package generatePatternDatabase;

public enum PatternDBSlidingSquareTrieFlyweight {
	COLLECTION;
	private PatternDBSlidingSquareTrie trie;

	private PatternDBSlidingSquareTrieFlyweight()
	{
		trie=new PatternDBSlidingSquareTrie();
	}
	public boolean exists(byte [] vals)
	{
		if(vals.length!=16)
			return false;
		else
		{
			return trie.exists(vals);
		}
	}
	private static byte[] convertToBytes(long square)
	{
		byte[] vals=new byte[16];
		for(int i=0; i<vals.length; i++)
		{
			vals[i]=(byte)(square&0x0F);
			square>>>=4;
		}
		return vals;
	}
	
	public boolean exists(long square)
	{
			return exists(convertToBytes(square));
	}

	public void add(long square, Byte value)
	{
		add(convertToBytes(square), value);
	}
	public void add(byte [] vals, Byte value)
	{
		trie.addNode(vals, value);
	}
	public void write() {
		trie.write();
	}
}