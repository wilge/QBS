import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;



public class TextChangerView extends JFrame implements ActionListener
{
	private JButton bSourceDirectory, bExit, bExecute;  
	private JButton bClear;
	private JLabel lSourceDirectory;
	private JLabel lSource;
	private JLabel lInicialText;
	private JLabel lReplaceWith;
	private JTextField eReplace;
	private JTextField eFind;
	private JTextField eExt2;
	private JPanel panel;
	private JTextField eExt1;
	private JTextField eExt3;
	private JTextField eExt4;
	private JTextField eExt5;
	private JLabel lExtensions;
	private JLabel lLogger;
	private JTextArea logger;
	
	
	public TextChangerView()
	{
		setSize(500, 400);
		
		setTitle("QBS Text Changer");
		setResizable(false);
		getContentPane().setLayout(null);
		bSourceDirectory = new JButton("Source directory");
		bSourceDirectory.setBounds(10, 11, 150, 20);
		getContentPane().add(bSourceDirectory);
		
		bExit = new JButton("Exit");
		bExit.setBounds(324, 331, 150, 20);
		getContentPane().add(bExit);
		
		lSourceDirectory = new JLabel("Source: ");
		lSourceDirectory.setBounds(170,	11, 52, 20);
		getContentPane().add(lSourceDirectory);
			
		bExecute = new JButton("Execute");
		bExecute.setBounds(10, 331, 150, 20);
		getContentPane().add(bExecute);
		
		lSource = new JLabel("");
		lSource.setBounds(222, 11, 252, 20);
		getContentPane().add(lSource);

		lInicialText = new JLabel("Find");
		lInicialText.setBounds(10, 87, 68, 20);
		getContentPane().add(lInicialText);
		
		lReplaceWith = new JLabel("Replace with");
		lReplaceWith.setBounds(10, 118, 81, 20);
		getContentPane().add(lReplaceWith);
		
		eReplace = new JTextField();
		eReplace.setBounds(98, 118, 237, 20);
		eReplace.setText("");
		getContentPane().add(eReplace);
		
		eFind = new JTextField();
		eFind.setBounds(98, 87, 237, 20);
		eFind.setText("");
		getContentPane().add(eFind);
	
		logger = new JTextArea();
		logger.setEditable(false);
		logger.setBounds(10, 161, 464, 163);
		getContentPane().add(logger);
		
		JScrollPane scrollPane = new JScrollPane(logger);
		getContentPane().add(scrollPane);
		scrollPane.setBounds(10, 161, 464, 163);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setName("");
		panel.setBounds(10, 47, 464, 30);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		eExt1 = new JTextField();
		eExt1.setBounds(7, 5, 86, 20);
		eExt1.setColumns(10);
		panel.add(eExt1);
		
		eExt2 = new JTextField();
		eExt2.setBounds(98, 5, 86, 20);
		panel.add(eExt2);
		eExt2.setColumns(10);
		
		eExt3 = new JTextField();
		eExt3.setBounds(189, 5, 86, 20);
		panel.add(eExt3);
		eExt3.setColumns(10);
		
		eExt4 = new JTextField();
		eExt4.setBounds(280, 5, 86, 20);
		panel.add(eExt4);
		eExt4.setColumns(10);
		
		eExt5 = new JTextField();
		eExt5.setBounds(371, 5, 86, 20);
		panel.add(eExt5);
		eExt5.setColumns(10);
		
		lExtensions = new JLabel("Extensions");
		lExtensions.setBounds(10, 34, 81, 14);
		getContentPane().add(lExtensions);
		
		lLogger = new JLabel("Logger");
		lLogger.setBounds(10, 147, 88, 14);
		getContentPane().add(lLogger);
		
		bClear = new JButton("Clear");
		bClear.setBounds(170, 331, 120, 20);
		getContentPane().add(bClear);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	public void log(String s){
	       logger.append(s + "\n");
	   }
	 
	public void addExitListener(ActionListener listenForExitButton)
	{
		bExit.addActionListener(listenForExitButton);
	}
	 
	public void addSourceDirectoryListener(ActionListener listenForSourceDirectoryButton)
	{
		bSourceDirectory.addActionListener(listenForSourceDirectoryButton);
	}
	 
	public void addExecuteListener(ActionListener listenForExecuteButton)
	{
		bExecute.addActionListener(listenForExecuteButton);
	}
	 
	public void addClearListener(ActionListener listenForClearButton)
	{
		bClear.addActionListener(listenForClearButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

	public JLabel getlSource()
	{
		return lSource;
	}

	public void setlSource(String txt)
	{
		this.lSource.setText(txt);
	}

	public JTextArea getLogger()
	{
		return logger;
	}

	public void setLogger(JTextArea logger)
	{
		this.logger = logger;
	}

	public JTextField geteExt2()
	{
		return eExt2;
	}

	public JTextField geteExt1()
	{
		return eExt1;
	}

	public JTextField geteExt3()
	{
		return eExt3;
	}

	public JTextField geteExt4()
	{
		return eExt4;
	}

	public JTextField geteExt5()
	{
		return eExt5;
	}

	public JTextField geteReplace()
	{
		return eReplace;
	}

	public JTextField geteFind()
	{
		return eFind;
	}


	
	
	
	
}
