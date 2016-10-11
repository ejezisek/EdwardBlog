package generatePatternDatabase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PatternDBSlidingSquareTrie {
	private byte [] connectedByteNodes=new byte[600_000_000];
	private int getIndex(byte[] values)
	{
		byte [] valuesCopy=values.clone();
		int[] availableValues={0,1,2,3,4,5,7,8};
		int actualIndex=0;
		int multiplier=16;
		for(int val:availableValues)
		{
			actualIndex*=multiplier--;
			int i=0;
			for(int index=0; index<valuesCopy.length; index++)
			{
				if(valuesCopy[index]!=-1)
					i++;
				if(val==valuesCopy[index])
				{
					valuesCopy[index]=-1;
					break;
				}
			}
			actualIndex+=i;
		}

		return actualIndex;
	}
	public void addNode(byte[] vals, byte value)
	{
		int index=getIndex(vals);
		connectedByteNodes[index]=(byte) (value+1);
	}
	public boolean exists(byte[] vals)
	{
		int index=getIndex(vals);
		return connectedByteNodes[index]!=0;
	}
	public byte get(byte[] vals)
	{
		int index=getIndex(vals);
		return (byte) (connectedByteNodes[index]-1);
	}
	public void write() {
		String filename = "/home/edward/Research/generatePatternDBFiles/results.out";
			try {
				Files.write(Paths.get(filename), connectedByteNodes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}
	
}
