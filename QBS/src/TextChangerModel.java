import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class TextChangerModel
{

	private List<File> files;
	private File dir; 
	private String text; 
	private int changeCount, filesChanged;
	private String[] ext;

	
	public void searchFiles(File dir, String[] ext)
	{
		this.files = (List<File>) FileUtils.listFiles(dir, ext, true);
		this.dir = dir;
	}
	
	public void changeText(File file, String in, String out) throws IOException
	{
		BufferedReader br;
		String textLine;
		int changeCount=0;
		text = "";
		
		{
		try
		{
			br = new BufferedReader(new FileReader(file));
			while ((textLine = br.readLine()) !=null)
			{
				if (textLine.contains(in)) 
				{
					text = text + textLine.replace(in, out) + '\n';
					changeCount++;
				}
				else 
				{
					text = text + textLine + "\r\n";
				}
			}
			
			br.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		if (changeCount > 0)
		{
			this.changeCount += changeCount;
			this.filesChanged += 1;
			saveFile(file);
		}
		}
	}
	
	public void saveFile(File file) throws IOException
	{
		BufferedWriter bw;
		try
		{
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(text);
			bw.flush();
			bw.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public File getDir()
	{
		return dir;
	}

	public void setDir(File dir)
	{
		this.dir = dir;
	}

	public String[] getExt()
	{
		return ext;
	}

	public void setExt(String[] ext)
	{
		this.ext = ext;
	}

	public List<File> getFiles()
	{
		return files;
	}

	public int getChangeCount()
	{
		return changeCount;
	}

	public int getFilesChanged()
	{
		return filesChanged;
	}

	public void setChangeCount(int changeCount)
	{
		this.changeCount = changeCount;
	}

	public void setFilesChanged(int filesChanged)
	{
		this.filesChanged = filesChanged;
	}
	
	
	

}
