import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class Bloc_Notes /*extends welcome_page*/  implements Runnable {
	 JFrame f ;
	boolean bbk = true;
static File file2;
static String filename;
Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
JButton dwb; 

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
JFrame wframe = new JFrame("Welcome");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
 public Bloc_Notes() throws IOException{	
 JMenuItem undomenu = new JMenuItem("Undo");
 UndoManager undomng = new UndoManager();
 JButton undo;
 JButton redo;

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    t = new Thread(this);  
	        t.start();  	      
	    dwb=new JButton(); 
	    dwb.setBackground(Color.WHITE);
	    dwb.setFont(new Font("Calibri", Font.PLAIN, 20));
	    dwb.setToolTipText("Time(hh:mm:ss");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     JTextField status;
	JFrame f = new JFrame("Bloc-Note");
	f.setResizable(true);
	Image icon = Toolkit.getDefaultToolkit().getImage("/home/sahib/Pictures/titleicon.png");    
	f.setIconImage(icon);    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	JMenuBar menubar = new JMenuBar();
	menubar.setBackground(new Color(250, 215,0,125));
	JMenu filem = new JMenu("File");
	filem.setFont(new Font("Calibri", Font.PLAIN, 20));
	JMenu edit = new JMenu("Edit");
	edit.setFont(new Font("Calibri", Font.PLAIN, 20));
	JMenu view = new JMenu("View");
	view.setFont(new Font("Calibri", Font.PLAIN, 20));
	JMenu format = new JMenu("Format");
	format.setFont(new Font("Calibri", Font.PLAIN, 20));
	JMenu help = new JMenu("Help");
	help.setFont(new Font("Calibri", Font.PLAIN, 20));
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	BufferedImage openimage = ImageIO.read(getClass().getResource("/imagefolder/open-file-icon.gif"));
	BufferedImage openret = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
	openret.getGraphics().drawImage(openimage,0,0,32,32,null);
	ImageIcon openicon = new ImageIcon(openret);	  
	JMenuItem open = new JMenuItem("Open",openicon);
	open.setBackground(Color.WHITE);
	open.setFont(new Font("Calibri", Font.PLAIN,18));
////////////////////////////////////////////////////////////////////////////////////////////////////////////
    BufferedImage newimage = ImageIO.read(getClass().getResource("/imagefolder/newimageicon.gif"));
    BufferedImage newret = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
    newret.getGraphics().drawImage(newimage,0,0,32,32,null);
    ImageIcon newicon = new ImageIcon(newret);
    JMenuItem New = new JMenuItem("New",newicon);
    New.setBackground(Color.WHITE);
	New.setFont(new Font("Calibri", Font.PLAIN, 18));
  
    BufferedImage saveimage = ImageIO.read(getClass().getResource("/imagefolder/saveimageicon.gif"));
    BufferedImage saveret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
    saveret.getGraphics().drawImage(saveimage,0,0,35,35,null);
    ImageIcon saveicon = new ImageIcon(saveret);
    JMenuItem save = new JMenuItem("Save",saveicon);
    save.setBackground(Color.WHITE);
    save.setFont(new Font("Calibri", Font.PLAIN, 18));
	
    BufferedImage printimage = ImageIO.read(getClass().getResource("/imagefolder/print.gif"));
    BufferedImage printret = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
    printret.getGraphics().drawImage(printimage,0,0,32,32,null);
    ImageIcon printicon = new ImageIcon(printret);
	JMenuItem print = new JMenuItem("Print",printicon);
	print.setBackground(Color.WHITE);
	print.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	BufferedImage exitimage = ImageIO.read(getClass().getResource("/imagefolder/Exitimage.gif"));
	BufferedImage exitret = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
	exitret.getGraphics().drawImage(exitimage,0,0,32,32,null);
	ImageIcon exiticon = new ImageIcon(exitret);
	JMenuItem exit = new JMenuItem("Exit",exiticon);
	exit.setBackground(Color.WHITE);
	exit.setFont(new Font("Calibri", Font.PLAIN,18));
	
	BufferedImage saveasimage = ImageIO.read(getClass().getResource("/imagefolder/save-as-xl.gif"));
	BufferedImage saveasret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	saveasret.getGraphics().drawImage(saveasimage,0,0,32,32,null);
	ImageIcon saveasicon = new ImageIcon(saveasret);
	JMenuItem SaveAs = new JMenuItem("SaveAs",saveasicon);
	SaveAs.setBackground(Color.WHITE);
	SaveAs.setFont(new Font("Calibri", Font.PLAIN,18));
	
	BufferedImage cutimage = ImageIO.read(getClass().getResource("/imagefolder/cutimageicon.gif"));
	BufferedImage cutret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	cutret.getGraphics().drawImage(cutimage,0,0,35,35,null);
	ImageIcon cuticon = new ImageIcon(cutret);
	JMenuItem cut = new JMenuItem("Cut",cuticon);
	cut.setBackground(Color.WHITE);
	cut.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	BufferedImage copyimage = ImageIO.read(getClass().getResource("/imagefolder/copyimageicon.gif"));
	BufferedImage copyret = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
	copyret.getGraphics().drawImage(copyimage,0,0,32,32,null);
	ImageIcon copyicon = new ImageIcon(copyret);
	JMenuItem copy = new JMenuItem("Copy",copyicon);
	copy.setBackground(Color.WHITE);
	copy.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	BufferedImage pasteimage = ImageIO.read(getClass().getResource("/imagefolder/pasteimageicon.gif"));
	BufferedImage pasteret = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
	pasteret.getGraphics().drawImage(pasteimage,0,0,32,32,null);
	ImageIcon pasteicon = new ImageIcon(pasteret);
	JMenuItem paste = new JMenuItem("Paste",pasteicon);
	paste.setBackground(Color.WHITE);
	paste.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	BufferedImage selectallimage = ImageIO.read(getClass().getResource("/imagefolder/select.gif"));
	BufferedImage selectallret = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
	selectallret.getGraphics().drawImage(selectallimage,0,0,32,32,null);
	ImageIcon selectallicon = new ImageIcon(selectallret);
	JMenuItem selectall = new JMenuItem("Select All",selectallicon);
	selectall.setBackground(Color.WHITE);
	selectall.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	BufferedImage undoimage = ImageIO.read(getClass().getResource("/imagefolder/Undoimage.gif"));
	BufferedImage undoret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	undoret.getGraphics().drawImage(undoimage,0,0,35,35,null);
	ImageIcon undoicon = new ImageIcon(undoret);
	JMenuItem undomi = new JMenuItem("Undo",undoicon);
	undomi.setBackground(Color.WHITE);
	undomi.setFont(new Font("Calibri", Font.PLAIN, 18));
    
	BufferedImage gotoimage = ImageIO.read(getClass().getResource("/imagefolder/gotoimageicon.gif"));
	BufferedImage gotoret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	gotoret.getGraphics().drawImage(gotoimage,0,0,35,35,null);
	ImageIcon gotoicon = new ImageIcon(gotoret);
	JMenuItem Goto = new JMenuItem("GoTo",gotoicon);
    Goto.setBackground(Color.WHITE);
	Goto.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	BufferedImage replaceimage = ImageIO.read(getClass().getResource("/imagefolder/replaceimageicon.gif"));
	BufferedImage replaceret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	replaceret.getGraphics().drawImage(replaceimage,0,0,35,35,null);
	ImageIcon replaceicon = new ImageIcon(replaceret);
	JMenuItem replace = new JMenuItem("Replace",replaceicon);
	replace.setBackground(Color.WHITE);
    replace.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	BufferedImage helpimage = ImageIO.read(getClass().getResource("/imagefolder/helpimageicon.gif"));
	BufferedImage helpret = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
	helpret.getGraphics().drawImage(helpimage,0,0,32,32,null);
	ImageIcon helpicon = new ImageIcon(helpret);
	JMenuItem gethelp = new JMenuItem("Get Help",helpicon);
	gethelp.setBackground(Color.WHITE);
	gethelp.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	BufferedImage fontimage = ImageIO.read(getClass().getResource("/imagefolder/fontimageicon.gif"));
	BufferedImage fontret = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
    fontret.getGraphics().drawImage(fontimage,0,0,32,32,null);
	ImageIcon fonticon = new ImageIcon(fontret);
	JMenuItem font = new JMenuItem("Font",fonticon);
	font.setBackground(Color.WHITE);
	font.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	BufferedImage redoimage = ImageIO.read(getClass().getResource("/imagefolder/redoimageicon.gif"));
	BufferedImage redoret = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
	redoret.getGraphics().drawImage(redoimage,0,0,32,32,null);
	ImageIcon redoicon = new ImageIcon(redoret);
	JMenuItem redomi = new JMenuItem("Redo",redoicon);
	redomi.setBackground(Color.WHITE);
	redomi.setFont(new Font("Calibri", Font.PLAIN, 18));
//////////////////////////////////////////////////////////////////////////////////////
	BufferedImage findimage = ImageIO.read(getClass().getResource("/imagefolder/findimageicon.gif"));
	BufferedImage findret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	findret.getGraphics().drawImage(findimage,0,0,35,35,null);
	ImageIcon findicon = new ImageIcon(findret);
	JMenuItem find = new JMenuItem("Find",findicon);
	find.setBackground(Color.WHITE);
	find.setFont(new Font("Calibri", Font.PLAIN, 18));
///////////////////////////////////////////////////////////////////////////////////
	BufferedImage wdimage = ImageIO.read(getClass().getResource("/imagefolder/wordwrap.gif"));
	BufferedImage wdret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	wdret.getGraphics().drawImage(wdimage,0,0,35,35,null);
	ImageIcon wdicon = new ImageIcon(wdret);
	JCheckBoxMenuItem wordwrap = new JCheckBoxMenuItem("WordWrap",wdicon);
	wordwrap.setBackground(Color.WHITE);
	wordwrap.setFont(new Font("Calibri", Font.PLAIN, 18));
////////////////////////////////////////////////////////////////////////////////////
	BufferedImage tdimage = ImageIO.read(getClass().getResource("/imagefolder/tdimageicon.gif"));
	BufferedImage tdret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	tdret.getGraphics().drawImage(tdimage,0,0,35,35,null);
	ImageIcon tdicon = new ImageIcon(tdret);
	JMenuItem Td = new JMenuItem("Time/Date",tdicon);
	Td.setBackground(Color.WHITE);
	Td.setFont(new Font("Calibri", Font.PLAIN, 18));
/////////////////////////////////////////////////////////////////////////////////
	BufferedImage tbimage = ImageIO.read(getClass().getResource("/imagefolder/tbimageicon.gif"));
	BufferedImage tbret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	tbret.getGraphics().drawImage(tbimage,0,0,35,35,null);
	ImageIcon tbicon = new ImageIcon(tbret);
	JCheckBoxMenuItem toolbar = new JCheckBoxMenuItem("ToolBar",tbicon);
	toolbar.setBackground(Color.WHITE);
	toolbar.setFont(new Font("Calibri", Font.PLAIN, 18));
/////////////////////////////////////////////////////////////////////////////////
	BufferedImage sbimage = ImageIO.read(getClass().getResource("/imagefolder/status.gif"));
	BufferedImage sbret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	sbret.getGraphics().drawImage(sbimage,0,0,35,35,null);
	ImageIcon sbicon = new ImageIcon(sbret);
	JCheckBoxMenuItem statusbar =  new JCheckBoxMenuItem("StatusBar",sbicon);
	statusbar.setBackground(Color.WHITE);
	statusbar.setFont(new Font("Calibri", Font.PLAIN, 18));
////////////////////////////////////////////////////////////////////////////////////
	BufferedImage aboutimage = ImageIO.read(getClass().getResource("/imagefolder/aboutimageicon.gif"));
	BufferedImage aboutret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
	aboutret.getGraphics().drawImage(aboutimage,0,0,35,35,null);
	ImageIcon abouticon = new ImageIcon(aboutret);
	JMenuItem about = new JMenuItem("About Bloc-Notes",abouticon);
	about.setBackground(Color.WHITE);
	about.setFont(new Font("Calibri", Font.PLAIN, 18));
////////////////////////////////////////////////////////////////////////////////////////
	JMenuItem popcut = new JMenuItem("Cut");
	popcut.setBackground(new Color(250, 215,0,100));
	popcut.setFont(new Font("Calibri", Font.PLAIN, 18));
/////////////////////////////////////////////////////////////////////////////////////////
	JMenuItem popcopy = new JMenuItem("Copy");
	popcopy.setBackground(new Color(250, 215,0,100));
	popcopy.setFont(new Font("Calibri", Font.PLAIN, 18));
///////////////////////////////////////////////////////////////////////////////////////////
	JMenuItem poppaste = new JMenuItem("Paste");
	poppaste.setBackground(new Color(250, 215,0,100));
	poppaste.setFont(new Font("Calibri", Font.PLAIN, 18));
////////////////////////////////////////////////////////////////////////////////////////////	
	JMenuItem popselectall = new JMenuItem("Select All");
	popselectall.setBackground(new Color(250, 215,0,100));
	popselectall.setFont(new Font("Calibri", Font.PLAIN, 18));
////////////////////////////////////////////////////////////////////////////////////////////
	JMenuItem popundo = new JMenuItem("Undo");
	popundo.setBackground(new Color(250, 215,0,100));
	popundo.setFont(new Font("Calibri", Font.PLAIN, 18));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	JPopupMenu popmenu = new JPopupMenu("POPMENU");
	popmenu.setBackground(new Color(250, 215,0,125));	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	JTextArea area = new JTextArea();
	JLabel Status = new JLabel("Status :");
	Status.setFont(new Font("Calibri",Font.PLAIN,22));
	JLabel S = new JLabel(" ");
	S.setFont(new Font("Calibri", Font.PLAIN, 22));
	JToolBar sb = new JToolBar();
	sb.setBackground(Color.WHITE);
	sb.setFloatable(true);
	sb.add(Status);sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.add(S);;sb.addSeparator();sb.addSeparator();sb.addSeparator();
	sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();
	sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();
	sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();
	sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.addSeparator();
	sb.addSeparator();sb.addSeparator();sb.addSeparator();sb.add(dwb);
	f.add(sb,BorderLayout.SOUTH);
	sb.setVisible(false);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	BufferedImage NEWimage = ImageIO.read(getClass().getResource("/imagefolder/newimageicon.png"));
	BufferedImage NEWret = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
	NEWret.getGraphics().drawImage(NEWimage,0,0,30,30,null);
	ImageIcon NEWicon = new ImageIcon(NEWret);
	JButton NEWFILE = new JButton(NEWicon);
	NEWFILE.setBackground(Color.WHITE);
	NEWFILE.setToolTipText("Create New File");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	BufferedImage CUTimage = ImageIO.read(getClass().getResource("/imagefolder/cutimageicon.png"));
	BufferedImage CUTret = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
	CUTret.getGraphics().drawImage(CUTimage,0,0,30,30,null);
	ImageIcon CUTicon = new ImageIcon(CUTret);
	JButton CUT = new JButton(CUTicon);
	CUT.setBackground(Color.WHITE);
	CUT.setToolTipText("Cut");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	BufferedImage COPYimage = ImageIO.read(getClass().getResource("/imagefolder/copyimageicon.png"));
	BufferedImage COPYret = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
	COPYret.getGraphics().drawImage(COPYimage,0,0,30,30,null);
	ImageIcon COPYicon = new ImageIcon(COPYret);
	JButton COPY = new JButton(COPYicon);
	COPY.setBackground(Color.WHITE);
	COPY.setToolTipText("Copy");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	BufferedImage PASTEimage = ImageIO.read(getClass().getResource("/imagefolder/pasteimageicon.png"));
	BufferedImage PASTEret = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
	PASTEret.getGraphics().drawImage(PASTEimage,0,0,30,30,null);
	ImageIcon PASTEicon = new ImageIcon(PASTEret);
	JButton PASTE = new JButton(PASTEicon);
	PASTE.setBackground(Color.WHITE);
	PASTE.setToolTipText("Paste");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	BufferedImage UNDOimage = ImageIO.read(getClass().getResource("/imagefolder/Undoimage.png"));
	BufferedImage UNDOret = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
	UNDOret.getGraphics().drawImage(UNDOimage,0,0,30,30,null);
	ImageIcon UNDOicon = new ImageIcon(UNDOret);
	JButton UNDO = new JButton(UNDOicon);
	UNDO.setBackground(Color.WHITE);
	UNDO.setToolTipText("Undo");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	BufferedImage FINDimage = ImageIO.read(getClass().getResource("/imagefolder/findimageicon.png"));
	BufferedImage FINDret = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
	FINDret.getGraphics().drawImage(FINDimage,0,0,30,30,null);
	ImageIcon FINDicon = new ImageIcon(FINDret);
	JButton FIND = new JButton(FINDicon);
	FIND.setBackground(Color.WHITE);
	FIND.setToolTipText("Find");
/////////////////////////////////////////////////////////////////////////////////////    
String[] fontnames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
String[] fontstyles = {"Plain","Bold","Italic","Plain+Bold","Plain+Italic","Bold+Italic"};
String[] fontsizes = {"14","16","18","20","24","28","32","36","40","45","50","56","72"};
JComboBox FONTSIZE = new JComboBox(fontsizes);
FONTSIZE.setBackground(Color.WHITE);
FONTSIZE.setToolTipText("Change Font Size");
JComboBox FONTSTYLE = new JComboBox(fontstyles);
FONTSTYLE.setBackground(Color.WHITE);
FONTSTYLE.setToolTipText("Change Font Style");
JComboBox FONTNAME  = new JComboBox(fontnames);
FONTNAME.setBackground(Color.WHITE);
FONTNAME.setToolTipText("Font Names");
JToolBar tb = new JToolBar();
tb.setFloatable(true);

///////////////////////////////////////////////////////////////////////////////////	
JLabel TOOLBAAR = new JLabel("ToolBar :      ");
tb.add(TOOLBAAR);tb.add(NEWFILE);tb.addSeparator();;tb.add(UNDO);tb.addSeparator();;tb.add(CUT);tb.addSeparator();;tb.add(COPY);tb.addSeparator();;tb.add(PASTE);
tb.addSeparator();;tb.add(FONTSIZE);tb.addSeparator();tb.add(FONTSTYLE);tb.addSeparator();tb.add(FONTNAME);tb.addSeparator();tb.add(FIND);
f.add(tb,BorderLayout.NORTH);
tb.setFont(new Font("Calibri", Font.PLAIN, 20));
tb.setBackground(Color.WHITE);
tb.setVisible(false);
////////////////////////////////////////////////////////////////////////////	
JScrollPane sp = new JScrollPane(area);
///////////////////////////////////////////////////////////////////////////	
area.setFont(new Font("Calibri",Font.PLAIN,20));	
////////////////////////////////////////////////////////////////////////////
filem.add(New);filem.addSeparator();filem.add(open);filem.addSeparator();filem.add(save);filem.addSeparator();
filem.add(SaveAs);filem.addSeparator();;filem.add(print);filem.addSeparator();filem.add(exit);	
///////////////////////////////////////////////////////////////////////////	
edit.add(undomi);edit.addSeparator();;edit.add(redomi);edit.addSeparator();;edit.add(cut);edit.addSeparator();edit.add(copy);edit.addSeparator();	
edit.add(paste);edit.addSeparator();edit.add(find);edit.addSeparator();edit.add(replace);edit.addSeparator();edit.add(Goto);
edit.addSeparator();edit.add(selectall);edit.addSeparator();;edit.add(Td);
//////////////////////////////////////////////////////////////////////////
help.add(gethelp);help.addSeparator();help.add(about);
///////////////////////////////////////////////////////////////////////////
format.add(font);
//////////////////////////////////////////////////////////////////////////
view.addSeparator();view.add(wordwrap);view.addSeparator();view.add(statusbar);view.addSeparator();view.add(toolbar);
////////////////////////////////////////////////////////////////////////////
popmenu.add(popundo);popmenu.addSeparator();popmenu.add(popcut);popmenu.add(popcopy);popmenu.add(poppaste);
popmenu.addSeparator();popmenu.add(popselectall);
////////////////////////////////////////////////////////////////////////	
menubar.add(filem);menubar.add(edit);menubar.add(format);menubar.add(view);menubar.add(help);
f.setJMenuBar(menubar);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
area.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e) {
if(SwingUtilities.isRightMouseButton(e))
popmenu.show(f, e.getX(), e.getY());
}
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
popundo.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
undomng.undo();
}catch(CannotUndoException cue) {
cue.getStackTrace();
}
}
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
popcut.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
area.cut();
}
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
popcopy.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
area.copy();
}
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
poppaste.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
area.paste();
}
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
popselectall.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
area.selectAll();
}
});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
NEWFILE.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
int a = JOptionPane.showConfirmDialog(exit,"Do You Want To Save?");     
f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);                                                            
if(a==JOptionPane.YES_OPTION) {     
JFileChooser savefile = new JFileChooser();
int i =savefile.showSaveDialog(f);
if(i==JFileChooser.APPROVE_OPTION) {			    	
File file = savefile.getSelectedFile();
try {
if(!file.exists()) {
file.createNewFile();
}
FileWriter fw = new FileWriter(file);
fw.write(area.getText());
fw.close();
}catch(IOException e1) {
e1.printStackTrace();
}
JOptionPane.showMessageDialog(f, "File saved", "Alert", JOptionPane.INFORMATION_MESSAGE);
}
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
area.setText("");
f.setVisible(true);
}
if(a==JOptionPane.NO_OPTION) {
area.setText("");
f.setVisible(true);
}
}
});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
UNDO.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
undomng.undo();
}catch(CannotUndoException cue) {
cue.getStackTrace();
}
}
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
CUT.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
area.cut();
}
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
COPY.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
area.copy();
}
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
PASTE.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
area.paste();
}
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
FONTSIZE.addActionListener(new  ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String fontname = FONTNAME.getSelectedItem().toString();
String fontstyle = FONTSTYLE.getSelectedItem().toString();
int fontsize = Integer.parseInt(FONTSIZE.getSelectedItem().toString().trim());
switch(fontstyle) {
case "Plain" :area.setFont(new Font(fontname,Font.PLAIN, fontsize));
break;
case "Bold" : area.setFont(new Font(fontname,Font.BOLD, fontsize));
break;

case "Italic" : area.setFont(new Font(fontname,Font.ITALIC, fontsize));
break;

case "Plain+Bold" : area.setFont(new Font(fontname,Font.PLAIN+Font.BOLD, fontsize));
break;

case "Plain+Italic" : area.setFont(new Font(fontname,Font.PLAIN+Font.ITALIC, fontsize));
break;

case "Bold+Italic" : area.setFont(new Font(fontname,Font.BOLD+Font.ITALIC, fontsize));
break;
}  		
}
});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
FONTSTYLE.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String fontname = FONTNAME.getSelectedItem().toString();
String fontstyle = FONTSTYLE.getSelectedItem().toString();
int fontsize = Integer.parseInt(FONTSIZE.getSelectedItem().toString().trim());
switch(fontstyle) {
case "Plain" :area.setFont(new Font(fontname,Font.PLAIN, fontsize));
break;
case "Bold" : area.setFont(new Font(fontname,Font.BOLD, fontsize));
break;

case "Italic" : area.setFont(new Font(fontname,Font.ITALIC, fontsize));
break;

case "Plain+Bold" : area.setFont(new Font(fontname,Font.PLAIN+Font.BOLD, fontsize));
break;

case "Plain+Italic" : area.setFont(new Font(fontname,Font.PLAIN+Font.ITALIC, fontsize));
break;

case "Bold+Italic" : area.setFont(new Font(fontname,Font.BOLD+Font.ITALIC, fontsize));
break;
}  		
}
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
FONTNAME.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String fontname = FONTNAME.getSelectedItem().toString();
String fontstyle = FONTSTYLE.getSelectedItem().toString();
int fontsize = Integer.parseInt(FONTSIZE.getSelectedItem().toString().trim());
switch(fontstyle) {
case "Plain" :area.setFont(new Font(fontname,Font.PLAIN, fontsize));
break;
case "Bold" : area.setFont(new Font(fontname,Font.BOLD, fontsize));
break;

case "Italic" : area.setFont(new Font(fontname,Font.ITALIC, fontsize));
break;

case "Plain+Bold" : area.setFont(new Font(fontname,Font.PLAIN+Font.BOLD, fontsize));
break;

case "Plain+Italic" : area.setFont(new Font(fontname,Font.PLAIN+Font.ITALIC, fontsize));
break;

case "Bold+Italic" : area.setFont(new Font(fontname,Font.BOLD+Font.ITALIC, fontsize));
break;
}  		
}
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
FIND.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame findframe = new JFrame("Find");
JLabel findlabel = new JLabel("Find");
findlabel.setBounds(10,20,100,40);
findlabel.setFont(new Font("Calibri", Font.BOLD, 18));
JTextField findarea = new JTextField();
findarea.setBounds(60,20,300,50);
findarea.setFont(new Font("Calibri", Font.PLAIN, 18));
JButton Find = new JButton("Find");
Find.setBounds(60,90,120,50);
JButton findall = new JButton("Find All");
findall.setBounds(240, 90, 120, 50);
JButton cancel = new JButton("Cancel");
cancel.setBounds(240, 150, 120, 50);
JButton ok = new JButton("Ok");
ok.setBounds(60, 150,120,50);
findframe.add(Find);findframe.add(findall);findframe.add(cancel);findframe.add(findarea);findframe.add(findlabel);findframe.add(ok);
///////////////////////////////////////////////////////////////////////////
Find.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
Highlighter h = area.getHighlighter();
String findtext = findarea.getText();
int  start = area.getText().indexOf(findtext);
if(start>=0 && findtext.length()>0 )
try {
h.addHighlight(start,start+findtext.length(),DefaultHighlighter.DefaultPainter);
findframe.addWindowListener(new WindowListener() {
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
    }
	@Override
	public void windowClosing(WindowEvent e) {
		h.removeAllHighlights();
    }
    @Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}
});
}
catch(BadLocationException be) {
be.getStackTrace();
}
else {
JOptionPane.showMessageDialog(null,"No match found");
}
}
});
/////////////////////////////////////////////////////////////////////////////////
cancel.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
findframe.setVisible(false);
}
});
///////////////////////////////////////////////////////////////////////////////////
findall.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try{Highlighter h = area.getHighlighter();
String findtext = findarea.getText();
Document doc = area.getDocument();
String text = doc.getText(0,doc.getLength());
int pos =0;
while((pos=text.toUpperCase().indexOf(findtext.toUpperCase(),pos))>=0) {
h.addHighlight(pos, pos+findtext.length(), DefaultHighlighter.DefaultPainter);
pos+=findtext.length();
}
}
catch(Exception e3) {
}
}
});
findframe.setSize(400, 250);
findframe.setLayout(null);
findframe.setVisible(true);
}
});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	    
New.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
int a = JOptionPane.showConfirmDialog(exit,"Do You Want To Save?");     
f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);                                                              //NEW BUTTON
if(a==JOptionPane.YES_OPTION) {     
JFileChooser savefile = new JFileChooser();
int i =savefile.showSaveDialog(f);
if(i==JFileChooser.APPROVE_OPTION) {			    	
File file = savefile.getSelectedFile();
try {
if(!file.exists()) {
file.createNewFile();
}
FileWriter fw = new FileWriter(file);
fw.write(area.getText());
fw.close();
}catch(IOException e1) {
e1.printStackTrace();
}
JOptionPane.showMessageDialog(f, "File saved", "Alert", JOptionPane.INFORMATION_MESSAGE);
}
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
area.setText("");
f.setVisible(true);
}
//IMPORTANT
if(a==JOptionPane.NO_OPTION) {
area.setText("");
f.setVisible(true);
}
}
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
save.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
	if(bbk==true) {
		JFileChooser savefile = new JFileChooser();
		 int i =savefile.showSaveDialog(f);
		       if(i==JFileChooser.APPROVE_OPTION) {
                 File file = savefile.getSelectedFile();
	    	      try {
	    		   if(!file.exists()) {
	    			   file.createNewFile();
	    		   }
	    		 FileWriter fw = new FileWriter(file);
	    	     fw.write(area.getText());
	    	     fw.close();
	    	     bbk=false;
	    	   }catch(IOException e1) {
	    		   e1.printStackTrace();
	    	   }
	        JOptionPane.showMessageDialog(f, "File saved", "Alert", JOptionPane.INFORMATION_MESSAGE);
	        file2=file;
	        filename = file.getName();
	}}
		       else {
		    	   try {
				FileWriter fr1;
				fr1 = new FileWriter(file2);
				fr1.write(area.getText());
			    fr1.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.getStackTrace();
			}  JOptionPane.showMessageDialog(f, "File saved", "Alert", JOptionPane.INFORMATION_MESSAGE);
		    	   
		       }
}                                                                  //SAVE BUTTON				
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
SaveAs.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
 bbk=true;
 JFileChooser savefile = new JFileChooser();
 int i =savefile.showSaveDialog(f);
 if(i==JFileChooser.APPROVE_OPTION) {                                                     //SAVE_AS BUTTON				    	
    File file = savefile.getSelectedFile();
    	 try {
    		  if(!file.exists()) {
    			 file.createNewFile();
    		   }
    		  else if(file.exists()) {  
    			   int b=JOptionPane.showConfirmDialog(f, "Do You Want To OverWrite Existing File?");
    			    if(b==JOptionPane.YES_OPTION) {
   					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   				    FileWriter fw = new FileWriter(file);
	    	        fw.write(area.getText());
	    	        fw.close();
	    	        bbk=false;
                    f.setVisible(false);}
    			    if(b==JOptionPane.NO_OPTION) {
    				   if(bbk==true) {
    					JFileChooser savefile1 = new JFileChooser();
    				    int c =savefile1.showSaveDialog(f);
    	  				if(c==JFileChooser.APPROVE_OPTION) {                                                                                                //SAVE BUTTON				    	
    					   File file3 = savefile1.getSelectedFile();
    					   try {
                                if(!file3.exists()) {
    					    	   file3.createNewFile();
    					    		   }   
    					        FileWriter fw = new FileWriter(file);
    					    	fw.write(area.getText());
    					    	fw.close();
    					    	bbk=false;
    					    	 }catch(IOException e1) {
    					    		   e1.printStackTrace();
    					    	   }
    					JOptionPane.showMessageDialog(f, "File saved", "Alert", JOptionPane.INFORMATION_MESSAGE);
    					file2=file3;
    					filename = file3.getName();
    	  				       }}
    			   }    				
    			  }else {
    				     FileWriter fw = new FileWriter(file);
			    	     fw.write(area.getText());
			    	     fw.close();
			    	     bbk=false;
    			  }
    		  }catch(IOException e1) {
    		   e1.printStackTrace();}
    	   }}
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
open.addActionListener(new ActionListener() {
@Override                                      
public void actionPerformed(ActionEvent e) {                                                                     //Open Button
JFileChooser openfile = new JFileChooser();
openfile.showOpenDialog(null);                                 //Choosing file and file path
File f = openfile.getSelectedFile();
String filename = f.getAbsolutePath();
try {
FileReader fr = new FileReader(filename);
BufferedReader br = new BufferedReader(fr);
area.read(br, null);
br.close();
area.requestFocus();
}catch(Exception e2) {
JOptionPane.showMessageDialog(null, e2);
}
}                                                                 
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
print.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
boolean complete = area.print();
if(complete) {
JOptionPane.showMessageDialog(null, "Done Printing","Information",JOptionPane.INFORMATION_MESSAGE);
}
else {
JOptionPane.showMessageDialog(null, "Printing", "Printer", JOptionPane.ERROR_MESSAGE);                      //Print Button
}
}
catch(PrinterException e1) {
JOptionPane.showMessageDialog(null,e1);
}
}
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
exit.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
int a = JOptionPane.showConfirmDialog(exit,"Are You Sure?");                                                          //EXIT BUTTON
f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
if(a==JOptionPane.YES_OPTION) {
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(false);
}
}
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
area.getDocument().addUndoableEditListener(new UndoableEditListener() {
@Override
public void undoableEditHappened(UndoableEditEvent e) {
undomng.addEdit(e.getEdit());
}
});	
undomi.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
undomng.undo();
}catch(CannotUndoException cue) {                                                   //Undo and Redo
cue.getStackTrace();
}
}
});
redomi.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
undomng.redo();
}catch(CannotRedoException cre) {
cre.getStackTrace();
}
}
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
cut.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
area.cut();                                                                                                             //CUT BUTTON
}
});
paste.addActionListener(new ActionListener() {
@Override                                                                                                                  //PASTE BUTTON
public void actionPerformed(ActionEvent e) {
area.paste();
}
});
copy.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {                                                                               //PASTE BUTTON
area.copy();
}
});
selectall.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {                                                                               //SELECT ALL BUTTON
area.selectAll();
}
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
find.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame findframe = new JFrame("Find");
JLabel findlabel = new JLabel("Find");
findlabel.setBounds(10,20,100,40);                                                      //Find and FindAll
findlabel.setFont(new Font("Calibri", Font.BOLD, 18));
JTextField findarea = new JTextField();
findarea.setBounds(60,20,300,50);
findarea.setFont(new Font("Calibri", Font.PLAIN, 18));
JButton Find = new JButton("Find");
Find.setBounds(60,90,120,50);
JButton findall = new JButton("Find All");
findall.setBounds(240, 90, 120, 50);
JButton cancel = new JButton("Cancel");
cancel.setBounds(240, 150, 120, 50);
JButton ok = new JButton("Ok");
ok.setBounds(60, 150,120,50);
findframe.add(Find);findframe.add(findall);findframe.add(cancel);findframe.add(findarea);findframe.add(findlabel);findframe.add(ok);
////////////////////////////////////////////////////////////////////////////
Find.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
Highlighter h = area.getHighlighter();
String findtext = findarea.getText();
int  start = area.getText().indexOf(findtext);
if(start>=0 && findtext.length()>0 )
try {
h.addHighlight(start,start+findtext.length(),DefaultHighlighter.DefaultPainter);
}
catch(BadLocationException be) {
be.getStackTrace();
}
else {
JOptionPane.showMessageDialog(null,"No match found");
}
}
});
//////////////////////////////////////////////////////////////////////////////////////////
ok.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
Highlighter h = area.getHighlighter();
String findtext = findarea.getText();
int  start = area.getText().indexOf(findtext);
if(start>=0 && findtext.length()>0 )
try {
h.addHighlight(start,start+findtext.length(),DefaultHighlighter.DefaultPainter);
findframe.addWindowListener(new WindowListener() {
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowClosing(WindowEvent e) {
		h.removeAllHighlights();
		}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}
});
}
catch(BadLocationException be) {
be.getStackTrace();
}
findframe.setVisible(false);
}
});
///////////////////////////////////////////////////////////////////////////////////
cancel.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
findframe.addWindowListener(new WindowListener() {
	Highlighter h = area.getHighlighter();
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
	h.removeAllHighlights();
		
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		}
});
findframe.setVisible(false);
}
});
//////////////////////////////////////////////////////////////////////////////////
findall.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try{
Highlighter h = area.getHighlighter();
h.removeAllHighlights();
String findtext = findarea.getText();
Document doc = area.getDocument();
String text = doc.getText(0,doc.getLength());
int pos =0;
while((pos=text.toUpperCase().indexOf(findtext.toUpperCase(),pos))>=0) {
h.addHighlight(pos, pos+findtext.length(), DefaultHighlighter.DefaultPainter);
pos+=findtext.length();
findframe.addWindowListener(new WindowListener() {
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowClosing(WindowEvent e) {
		h.removeAllHighlights();
		}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
			}
});
}
}
catch(Exception e3) {
}
}
});
findframe.setSize(400, 250);
findframe.setLayout(null);
findframe.setVisible(true);
}
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
BufferedImage okrimage = ImageIO.read(getClass().getResource("/imagefolder/ok.gif"));
BufferedImage okrret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
okrret.getGraphics().drawImage(okrimage,0,0,35,35,null);
ImageIcon okricon = new ImageIcon(okrret);
BufferedImage cancelrimage = ImageIO.read(getClass().getResource("/imagefolder/cancel.gif"));
BufferedImage cancelrret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
cancelrret.getGraphics().drawImage(cancelrimage,0,0,35,35,null);
ImageIcon cancelricon = new ImageIcon(cancelrret);
BufferedImage replacerimage = ImageIO.read(getClass().getResource("/imagefolder/replaceimageicon.gif"));
BufferedImage replacerret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
replacerret.getGraphics().drawImage(replacerimage,0,0,35,35,null);
ImageIcon replacericon = new ImageIcon(replacerret);
BufferedImage replaceallrimage = ImageIO.read(getClass().getResource("/imagefolder/replaceall.gif"));
BufferedImage replaceallrret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
replaceallrret.getGraphics().drawImage(replaceallrimage,0,0,35,35,null);
ImageIcon replaceallricon = new ImageIcon(replaceallrret);
replace.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame replaceframe= new JFrame("Replace");
JLabel replacelabel = new JLabel("Replace");
replacelabel.setBounds(10,20,80,50);                                                                  //Replace and ReplaceAll
replacelabel.setFont(new Font("Calibri", Font.BOLD, 18));
JTextField replacearea1 = new JTextField();
replacearea1.setBounds(100,20,200,50);
replacearea1.setFont(new Font("Calibri",Font.PLAIN,18));
JLabel with = new JLabel("With");
with.setBounds(180, 90,70,50);
with.setFont(new Font("Calibri",Font.BOLD,18));
JTextField replacearea2 = new JTextField();
replacearea2.setBounds(100, 170, 200, 50);
replacearea2.setFont(new Font("Calibri", Font.PLAIN, 18));
JButton replace = new JButton("Replace",replacericon);
replace.setBounds(340,20,150,50);
replace.setBackground(Color.WHITE);
JButton replaceall = new JButton("Replace All",replaceallricon);
replaceall.setBounds(340, 90,150, 50);
replaceall.setBackground(Color.WHITE);
JButton cancelr = new JButton("Cancel",cancelricon);
cancelr.setBounds(340,250, 150, 50);
cancelr.setBackground(Color.WHITE);
JButton okr = new JButton("Ok",okricon);
okr.setBounds(340, 170, 150, 50);
okr.setBackground(Color.WHITE);
replaceframe.add(replacearea1);replaceframe.add(with);replaceframe.add(replacearea2);replaceframe.add(replace);
replaceframe.add(replaceall);replaceframe.add(cancelr);
replaceframe.add(replacelabel);replaceframe.add(okr);
////////////////////////////////////////////////////////////////////////////////
okr.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String replacetext = replacearea1.getText();
int  start = area.getText().indexOf(replacetext);
if(start>=0 && replacetext.length()>0) {
area.replaceRange(replacearea2.getText(),start,start+replacetext.length());
}
replaceframe.setVisible(false);	
}
});
cancelr.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
replaceframe.setVisible(false);
}
});
/////////////////////////////////////////////////////////////////////////////////
replace.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String replacetext = replacearea1.getText();

int  start = area.getText().indexOf(replacetext);
if(start>=0 && replacetext.length()>0) {
area.replaceRange(replacearea2.getText(),start,start+replacetext.length());
}
else {
JOptionPane.showMessageDialog(null,"No match found");
}
}
});
/////////////////////////////////////////////////////////////////////////////////////
replaceall.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String rtext = area.getText();
String replacetext = replacearea1.getText();	
String withtext = replacearea2.getText();
replacetext = rtext.replaceAll(replacetext, withtext);
area.setText(replacetext);
}
});
replaceframe.setBounds(800, 450, 500, 350);
replaceframe.setLayout(null);
replaceframe.setVisible(true);
}
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
BufferedImage gotoimage1 = ImageIO.read(getClass().getResource("/imagefolder/gotoimageicon.gif"));
BufferedImage gotoret1 = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
gotoret1.getGraphics().drawImage(gotoimage1,0,0,35,35,null);
ImageIcon gotoicon1 = new ImageIcon(gotoret1);
Goto.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame gotoframe = new JFrame("GoTo");
JTextField gotoarea = new JTextField();
gotoarea.setBounds(90, 50, 150, 50);
gotoarea.setFont(new Font("Calibri", Font.PLAIN,18));
JButton gotobutton = new JButton("GoTo",gotoicon1);                                                        //GoTo Button
gotobutton.setBounds(90, 150, 150,50);
gotobutton.setBackground(Color.WHITE);
JLabel gotolabel = new JLabel("GoTo :");
gotolabel.setBounds(20, 50, 100, 50);
gotolabel.setFont(new Font("Calibri", Font.BOLD, 18));
gotoframe.add(gotoarea);gotoframe.add(gotobutton);gotoframe.add(gotolabel);
gotobutton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String gototext = area.getText();
int gotonumber = Integer.parseInt(gotoarea.getText().toString());
		area.setCaretPosition(gotonumber);
}
});
gotoframe.setBounds(800, 450, 300, 300);
gotoframe.setLayout(null);
gotoframe.setVisible(true);
}
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Td.addActionListener(new ActionListener() {                                    
//Time and Date
@Override
public void actionPerformed(ActionEvent e) {
Date date = new Date();
area.setText(date.toString());
}
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
gethelp.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
Desktop d = Desktop.getDesktop();
try {                                                                                                     //gethelp
d.browse(new URI("https://www.slideshare.net/info_zybotech/notepad-tutorial"));
} catch (IOException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (URISyntaxException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
}
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
BufferedImage okimage = ImageIO.read(getClass().getResource("/imagefolder/ok.gif"));
BufferedImage okret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
okret.getGraphics().drawImage(okimage,0,0,35,35,null);
ImageIcon okicon = new ImageIcon(okret);
JButton ok = new JButton("Ok",okicon);
ok.setBounds(600, 220, 100, 50);
ok.setBackground(Color.WHITE);
BufferedImage cancelimage = ImageIO.read(getClass().getResource("/imagefolder/cancel.gif"));
BufferedImage cancelret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
cancelret.getGraphics().drawImage(cancelimage,0,0,35,35,null);
ImageIcon cancelicon = new ImageIcon(cancelret);
JButton cancel = new JButton("Cancel",cancelicon);
cancel.setBounds(600, 370, 150, 50);
cancel.setBackground(Color.WHITE);
BufferedImage applyimage = ImageIO.read(getClass().getResource("/imagefolder/apply.gif"));
BufferedImage applyret = new BufferedImage(35,35,BufferedImage.TYPE_INT_ARGB);
applyret.getGraphics().drawImage(applyimage,0,0,35,35,null);
ImageIcon applyicon = new ImageIcon(applyret);
JButton apply = new JButton("Apply",applyicon);
apply.setBounds(600, 295, 150,50);
apply.setBackground(Color.WHITE);
font.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JFrame fframe = new JFrame("Fontbox");                                                                               //FONT MENU
JLabel preview1 = new JLabel("Preview");
preview1.setBounds(50,180, 100,50);
preview1.setFont(new Font("Calibri",Font.BOLD,18));
JLabel fonttype = new JLabel("Font Types:");
fonttype.setBounds(50, 5, 100, 40);
JLabel fontstyle = new JLabel("Font Style:");
fontstyle.setBounds(280, 5, 100, 40);
JLabel fontsize = new JLabel("FontSize:");
fontsize.setBounds(430, 5, 100, 40);
String[] fontnames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
String[] fontstyles = {"Plain","Bold","Italic","Plain+Bold","Plain+Italic","Bold+Italic"};
String[] fontsizes = {"14","16","18","20","24","28","32","36","40","45","50","56","72"};
JComboBox fontslist = new JComboBox(fontnames);
fontslist.setBounds(50,40,200,20);
fontslist.setBackground(Color.WHITE);
JComboBox fontStylelist = new JComboBox(fontstyles);
fontStylelist.setBounds(280, 40, 120, 20);
fontStylelist.setBackground(Color.WHITE);
JComboBox fontSizelist = new JComboBox(fontsizes);
fontSizelist.setBounds(430, 40,100, 20);
fontSizelist.setBackground(Color.WHITE);
JTextField previewarea = new JTextField("ABCDEFGH@!!!!%%%%$$&&+*"+"\n"+"1234567"+"\n"+"ijklmnopqrstu");
previewarea.setBounds(50, 220, 500, 200);
previewarea.setFont(new Font("Calibri", Font.PLAIN, 18));
/////////////////////////////////////////////////////////////////////////////////////////////
fontslist.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String fontname = fontslist.getSelectedItem().toString();
String fontstyle = fontStylelist.getSelectedItem().toString();
int fontsize = Integer.parseInt(fontSizelist.getSelectedItem().toString().trim());
String l=previewarea.getSelectedText();
switch(fontstyle) {
case "Plain" : previewarea.setFont(new Font(fontname,Font.PLAIN, fontsize));
break;
case "Bold" : previewarea.setFont(new Font(fontname,Font.BOLD, fontsize));
break;

case "Italic" : previewarea.setFont(new Font(fontname,Font.ITALIC, fontsize));
break;

case "Plain+Bold" : previewarea.setFont(new Font(fontname,Font.PLAIN+Font.BOLD, fontsize));
break;

case "Plain+Italic" : previewarea.setFont(new Font(fontname,Font.PLAIN+Font.ITALIC, fontsize));
break;

case "Bold+Italic" : previewarea.setFont(new Font(fontname,Font.BOLD+Font.ITALIC, fontsize));
break;
}
}	
});
////////////////////////////////////////////////////////////////////////////////////////////////
fontStylelist.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String fontname = fontslist.getSelectedItem().toString();
String fontstyle = fontStylelist.getSelectedItem().toString();
int fontsize = Integer.parseInt(fontSizelist.getSelectedItem().toString().trim());
switch(fontstyle) {
case "Plain" : previewarea.setFont(new Font(fontname,Font.PLAIN, fontsize));
break;
case "Bold" : previewarea.setFont(new Font(fontname,Font.BOLD, fontsize));
break;

case "Italic" : previewarea.setFont(new Font(fontname,Font.ITALIC, fontsize));
break;

case "Plain+Bold" : previewarea.setFont(new Font(fontname,Font.PLAIN+Font.BOLD, fontsize));
break;

case "Plain+Italic" : previewarea.setFont(new Font(fontname,Font.PLAIN+Font.ITALIC, fontsize));
break;

case "Bold+Italic" : previewarea.setFont(new Font(fontname,Font.BOLD+Font.ITALIC, fontsize));
break;
}
}	
});
///////////////////////////////////////////////////////////////////////////////////////////
fontSizelist.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String fontname = fontslist.getSelectedItem().toString();
String fontstyle = fontStylelist.getSelectedItem().toString();
int fontsize = Integer.parseInt(fontSizelist.getSelectedItem().toString().trim());
switch(fontstyle) {
case "Plain" : previewarea.setFont(new Font(fontname,Font.PLAIN, fontsize));
break;
case "Bold" : previewarea.setFont(new Font(fontname,Font.BOLD, fontsize));
break;

case "Italic" : previewarea.setFont(new Font(fontname,Font.ITALIC, fontsize));
break;

case "Plain+Bold" : previewarea.setFont(new Font(fontname,Font.PLAIN+Font.BOLD, fontsize));
break;

case "Plain+Italic" : previewarea.setFont(new Font(fontname,Font.PLAIN+Font.ITALIC, fontsize));
break;

case "Bold+Italic" : previewarea.setFont(new Font(fontname,Font.BOLD+Font.ITALIC, fontsize));
break;
}  		
}	
});
/////////////////////////////////////////////////////////////////////////////////

apply.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
	area.addCaretListener(new CaretListener() {
		
		@Override
		public void caretUpdate(CaretEvent e) {
			Object source = e.getSource();
			if(source==apply) {
			String fontname = fontslist.getSelectedItem().toString();
			String fontstyle = fontStylelist.getSelectedItem().toString();
			int fontsize = Integer.parseInt(fontSizelist.getSelectedItem().toString().trim());
			switch(fontstyle) {
			case "Plain" : area.setFont(new Font(fontname,Font.PLAIN, fontsize));
			break;
			case "Bold" : area.setFont(new Font(fontname,Font.BOLD, fontsize));
			break;

			case "Italic" : area.setFont(new Font(fontname,Font.ITALIC, fontsize));
			break;

			case "Plain+Bold" : area.setFont(new Font(fontname,Font.PLAIN+Font.BOLD, fontsize));
			break;

			case "Plain+Italic" : area.setFont(new Font(fontname,Font.PLAIN+Font.ITALIC, fontsize));
			break;

			case "Bold+Italic" : area.setFont(new Font(fontname,Font.BOLD+Font.ITALIC, fontsize));
			break;
			}	
			}	
		}
	});

}
});
///////////////////////////////////////////////////////////////////////////////////
cancel.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
fframe.setVisible(false);
}
});	
///////////////////////////////////////////////////////////////////////////////////
ok.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
Object source = e.getSource();
if(source==ok) {
String fontname = fontslist.getSelectedItem().toString();
String fontstyle = fontStylelist.getSelectedItem().toString();
int fontsize = Integer.parseInt(fontSizelist.getSelectedItem().toString().trim());
switch(fontstyle) {
case "Plain" : area.setFont(new Font(fontname,Font.PLAIN, fontsize));
break;
case "Bold" : area.setFont(new Font(fontname,Font.BOLD, fontsize));
break;

case "Italic" : area.setFont(new Font(fontname,Font.ITALIC, fontsize));
break;

case "Plain+Bold" : area.setFont(new Font(fontname,Font.PLAIN+Font.BOLD, fontsize));
break;

case "Plain+Italic" : area.setFont(new Font(fontname,Font.PLAIN+Font.ITALIC, fontsize));
break;

case "Bold+Italic" : area.setFont(new Font(fontname,Font.BOLD+Font.ITALIC, fontsize));
break;
}
}	
fframe.setVisible(false);
}
});
fframe.add(fontslist);fframe.add(fontStylelist);fframe.add(fontSizelist);fframe.add(apply);
fframe.add(cancel);fframe.add(ok);fframe.add(preview1);fframe.add(previewarea);fframe.add(fonttype);
fframe.add(fontsize);fframe.add(fontstyle);
fframe.setSize(800, 500);
fframe.setLayout(null);
fframe.setVisible(true);
}
});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
toolbar.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if(toolbar.isSelected()) {
tb.setVisible(true);
}
else{
tb.setVisible(false);
}
}
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
statusbar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
if(statusbar.isSelected()) {
area.addCaretListener(new CaretListener() {
	
	@Override
	public void caretUpdate(CaretEvent e) {
		int n = area.getCaretPosition();
		String p = Integer.toString(n);
		Status.setText(p);
		
	}
});

sb.setVisible(true);
}
else {
sb.setVisible(false);
}
}
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
wordwrap.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if(wordwrap.isSelected()) {
area.setLineWrap(true);
}
else {
area.setLineWrap(false);
}
}
});
f.addWindowListener(new WindowListener() {
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowClosing(WindowEvent e) {
		int a = JOptionPane.showConfirmDialog(exit,"Are You Sure?");                                                          //EXIT BUTTON
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		if(a==JOptionPane.YES_OPTION) {
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(false);}
		}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		}
});
	f.add(sp);area.add(popmenu);
	f.setBounds(500, 150, 950, 800);
    
	f.setVisible(true);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
 public static void main(String[] args) throws IOException {
		//welcome_page m=new welcome_page();
		//m.iterate();
		new Bloc_Notes();
	    
	
	}
    @Override
	public void run() {
		   try {  
		         while (true) {  
		  
		            Calendar cal = Calendar.getInstance();  
		            hours = cal.get( Calendar.HOUR_OF_DAY );  
		            if ( hours > 12 ) hours -= 12;  
		            minutes = cal.get( Calendar.MINUTE );  
		            seconds = cal.get( Calendar.SECOND );  
		  
		            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");  
		            Date date = cal.getTime();  
		            timeString = formatter.format( date );  
		  
		            printTime();  
		  
		            t.sleep( 1000 );  // interval given in milliseconds  
		         }  
		      }  
		      catch (Exception e) { }  
		
	}
	public void printTime(){  
		dwb.setText(timeString);  
		}
	/*void welcome_page(){    
		wframe= new JFrame("Welcome");
		jb=new JProgressBar(0,2000);    
		jb.setBounds(100,250,200,30);         
		jb.setValue(0);  
		jb.setBackground(Color.WHITE);
		jb.setStringPainted(true);    
		wframe.add(jb); 
		
		wframe.setSize(400,400);    
		wframe.setLayout(null);
		wframe.setVisible(true);
		}*/
	
		    
		      
	

}
