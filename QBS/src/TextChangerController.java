import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;


public class TextChangerController
{

	private TextChangerModel model;
	private TextChangerView view;
	
	public TextChangerController(TextChangerModel model, TextChangerView view)
	{
		this.model = model;
		this.view = view;
		
		this.view.addExitListener(new ExitListener());
		this.view.addSourceDirectoryListener(new SourceDirectoryListener());
		this.view.addExecuteListener(new ExecuteListener());
		this.view.addClearListener(new ClearListener());
		
	}
	
	class ExitListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			view.dispose();
			
		}
		
	}
	class SourceDirectoryListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			{
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("."));
				fc.setCurrentDirectory(new java.io.File(view.getlSource().getText()));
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
				{
					File directory = fc.getSelectedFile();
					if (directory.isFile()) directory = fc.getCurrentDirectory();
					view.setlSource((directory.getAbsolutePath().toString()));		
					view.getlSource().setToolTipText(directory.getAbsolutePath().toString());
				}
			}		
		}
		
	}
	class ExecuteListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			 String directory = ".";
			 String[] extensions = new String[] {"txt"};
			 if (view.getlSource().getText() !="")
			 {
				 directory = view.getlSource().getText();
			 }
			 
			 extensions = new String[] {
			 view.geteExt1().getText(),
			 view.geteExt2().getText(),
			 view.geteExt3().getText(),
			 view.geteExt4().getText(),
			 view.geteExt5().getText(),
			 };
			 
			 
	        File dir = new File(directory);
	        model.searchFiles(dir, extensions);
	        if (model.getFiles().isEmpty())
	        {
	        	view.log("There are no files with this extensions in this destination");
	        }
	        else
	        {
	        	view.log("File list:");
	        	for (File file : model.getFiles())
					try
					{
						view.log(file.getCanonicalPath());
					} catch (IOException e1)
					{
						e1.printStackTrace();
					}
	        
	        	if (view.geteFind().getText()!="")
	        	{
	        		for (File file : model.getFiles())
	        			try
		        		{
	        				if (view.geteFind().getText().length() > 0)
	        				{
							model.changeText(file, view.geteFind().getText(), view.geteReplace().getText());
	        				}
		        		} catch (IOException e)
		        		{
							e.printStackTrace();
						}
	        		view.log("");
	        		view.log(model.getFiles().size() + " files found.");
	        		view.log(model.getFilesChanged() + " files changed.");
	        		view.log(model.getChangeCount() + " changes in files.");
	        		view.log("-------------------------------------");
	        		model.setChangeCount(0);
	        		model.setFilesChanged(0);
	        	}
	        }
		}		
	}	
	class ClearListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			view.getLogger().setText("");
			view.geteReplace().setText("");
			view.geteFind().setText("");
			view.getlSource().setText("");
			view.geteExt1().setText("");
			view.geteExt2().setText("");
			view.geteExt3().setText("");
			view.geteExt4().setText("");
			view.geteExt5().setText("");
			
		}
		
	}

	
	
}
