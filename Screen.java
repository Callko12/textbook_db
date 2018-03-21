import java.io.*; 
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
import java.lang.Object;
import javax.swing.*;

public class Screen {

	Text_Lib libs;
 	JTextField Aname, Atit, Auniv, Aexp, A_ID;
   	JTextField TTitle, TPub, TRate, TSubj, TAuth, TYear, TEd, TPri, T_ID;
	JButton BCont, BQuit;
	JFrame TempFrame;
	Connection conn1;


	public void addAuthor(Text_Lib library, Connection conn) {
	conn1 = conn;

	// Cleans the screen, preparing to be filled again
		library.frame.setVisible(false);

		JPanel Wpanel, prompt, who, what, where, exp, buttons;
		JButton addAuth;

		TempFrame = new JFrame();
		TempFrame.setSize(400,400);
		TempFrame.setLayout(new BorderLayout());
		TempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			Wpanel = new JPanel();
			Wpanel.add(new JLabel("Who would you like to add?"));
		
			Aname = new JTextField(20);
			Atit = new JTextField(20);
			Auniv = new JTextField(20);
			Aexp = new JTextField(20);

			prompt = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

				who = new JPanel();
				who.add(new JLabel("Name: "));
				who.add(Aname);
				c.gridx = 0;
				c.gridy = 1;
				prompt.add(who,c);

				what = new JPanel();
				what.add(new JLabel("Title: "));
				what.add(Atit);
				c.gridy = 2;
				prompt.add(what,c);

				where = new JPanel();
				where.add(new JLabel("University: "));
				where.add(Auniv);
				c.gridy = 3;
				prompt.add(where,c);

				exp = new JPanel();
				exp.add(new JLabel("Area of Expertise: "));
				exp.add(Aexp);
				c.gridy = 4;
				prompt.add(exp,c);


			buttons = new JPanel();
			buttons.setLayout(new FlowLayout());
				BCont = new JButton("Continue");
				BCont.setPreferredSize(new Dimension(100, 50));
				BCont.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						// Need to create indexes for added entries
						String query1 = "insert into AUTHOR (NAME, TITLE, UNIVERSITY, EXPERTISE) values (\"" +Aname.getText()+ "\", \""
								+Atit.getText()+ "\", \""
								+Auniv.getText()+ "\", \""
								+Aexp.getText()+ "\")";
						try
						{
							Statement stmt = conn1.createStatement();
							int i = stmt.executeUpdate( query1 ); // do the update

						}
						catch( SQLException ex ) 
						{
							System.out.println( "SQL Exception: " 
								+ ex.getMessage());
							ex.printStackTrace();
						}
						TempFrame.getContentPane().removeAll();
						TempFrame.setVisible(false);
						libs.frame.revalidate();
						libs.frame.repaint();
						libs.frame.setVisible(true);
						return;
						}
					});
				buttons.add(BCont);
				BQuit = new JButton("Quit");
				BQuit.setPreferredSize(new Dimension(100, 50));
				BQuit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				});
				buttons.add(BQuit);

			TempFrame.add(Wpanel, BorderLayout.PAGE_START);
			TempFrame.add(prompt, BorderLayout.CENTER);
			TempFrame.add(buttons, BorderLayout.PAGE_END);
			TempFrame.setVisible(true);

		libs = library;
	   }


public void deleteAuthor(Text_Lib library, Connection conn) {
	conn1 = conn;

	// Cleans the screen, preparing to be filled again
		library.frame.setVisible(false);

		JPanel Wpanel, prompt, who, what, where, exp, buttons;
		JButton addAuth;

		TempFrame = new JFrame();
		TempFrame.setSize(400,400);
		TempFrame.setLayout(new BorderLayout());
		TempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			Wpanel = new JPanel();
			Wpanel.add(new JLabel("Who would you like to delete?"));
		
			A_ID = new JTextField(20);

			prompt = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

				who = new JPanel();
				who.add(new JLabel("Author's ID number: "));
				who.add(A_ID);
				c.gridx = 0;
				c.gridy = 1;
				prompt.add(who,c);

			buttons = new JPanel();
			buttons.setLayout(new FlowLayout());
				BCont = new JButton("Continue");
				BCont.setPreferredSize(new Dimension(100, 50));
				BCont.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						// Need to create indexes for added entries
						String query1 = "delete from AUTHOR where AUTHOR_ID=" +A_ID.getText()+ ";";
						try
						{
							Statement stmt = conn1.createStatement();
							int i = stmt.executeUpdate( query1 ); // do the update

						}
						catch( SQLException ex ) 
						{
							System.out.println( "SQL Exception: " 
								+ ex.getMessage());
							ex.printStackTrace();
						}
						TempFrame.getContentPane().removeAll();
						TempFrame.setVisible(false);
						libs.frame.revalidate();
						libs.frame.repaint();
						libs.frame.setVisible(true);
						return;
						}
					});
				buttons.add(BCont);
				BQuit = new JButton("Quit");
				BQuit.setPreferredSize(new Dimension(100, 50));
				BQuit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				});
				buttons.add(BQuit);

			TempFrame.add(Wpanel, BorderLayout.PAGE_START);
			TempFrame.add(prompt, BorderLayout.CENTER);
			TempFrame.add(buttons, BorderLayout.PAGE_END);
			TempFrame.setVisible(true);

		libs = library;
	   }


public void addTextbook(Text_Lib library, Connection conn) {
	conn1 = conn;
// Cleans the screen, preparing to be filled again
	library.frame.setVisible(false);

	JPanel Wpanel, prompt, title, pub, rate, subj, auth, year, ed, pri, buttons;

		TempFrame = new JFrame();
		TempFrame.setSize(400,400);
		Wpanel = new JPanel();
		Wpanel.add(new JLabel("Who would you like to add?"));
		
		TTitle = new JTextField(20);
		TPub = new JTextField(20);
		TRate = new JTextField(20);
		TSubj = new JTextField(20);
		TAuth = new JTextField(20);
		TYear = new JTextField(20);
		TEd = new JTextField(20);
		TPri = new JTextField(20);

		prompt = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

			title = new JPanel();
			title.add(new JLabel("Title: "));
			title.add(TTitle);
			c.gridx = 0;
			c.gridy = 1;
			prompt.add(title,c);

			pub = new JPanel();
			pub.add(new JLabel("Publisher ID: "));
			pub.add(TPub);
			c.gridy = 2;
			prompt.add(pub,c);

			rate = new JPanel();
			rate.add(new JLabel("Rating: "));
			rate.add(TRate);
			c.gridy = 3;
			prompt.add(rate,c);

			subj = new JPanel();
			subj.add(new JLabel("Subject ID: "));
			subj.add(TSubj);
			c.gridy = 4;
			prompt.add(subj,c);

			auth = new JPanel();
			auth.add(new JLabel("Author ID: "));
			auth.add(TAuth);
			c.gridy = 5;
			prompt.add(auth,c);

			year = new JPanel();
			year.add(new JLabel("Year: "));
			year.add(TYear);
			c.gridy = 6;
			prompt.add(year,c);

			ed = new JPanel();
			ed.add(new JLabel("Edition: "));
			ed.add(TEd);
			c.gridy = 7;
			prompt.add(ed,c);

			pri = new JPanel();
			pri.add(new JLabel("Price: "));
			pri.add(TPri);
			c.gridy = 8;
			prompt.add(pri,c);


		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
			BCont = new JButton("Continue");
			BCont.setPreferredSize(new Dimension(100, 50));
			BCont.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String query1 = "insert into BOOK (TITLE, PUBLISHER_ID, RATING, SUBJECT_ID, AUTHOR_ID, YEAR, EDITION, PRICE) values (\"" +TTitle.getText()+ "\", "
					+TPub.getText()+ ", "
					+TRate.getText()+ ", \""
					+TSubj.getText()+ "\", \""
					+TAuth.getText()+ "\", "
					+TYear.getText()+ ", "
					+TEd.getText()+ ", "
					+TPri.getText()+ ")";
				try
				{
					Statement stmt = conn1.createStatement();
					int i = stmt.executeUpdate( query1 ); // do the update

				}
				catch( SQLException ex ) 
				{
					System.out.println( "SQL Exception: " 
						+ ex.getMessage());
					ex.printStackTrace();
				}
				TempFrame.getContentPane().removeAll();
				TempFrame.setVisible(false);
				libs.frame.revalidate();
				libs.frame.repaint();
				libs.frame.setVisible(true);
		}});
			buttons.add(BCont);
			BQuit = new JButton("Quit");
			BQuit.setPreferredSize(new Dimension(100, 50));
			BQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
			buttons.add(BQuit);

		TempFrame.add(Wpanel, BorderLayout.PAGE_START);
		TempFrame.add(prompt, BorderLayout.CENTER);
		TempFrame.add(buttons, BorderLayout.PAGE_END);
		TempFrame.setVisible(true);

		libs = library;
   }


public void deleteTextbook(Text_Lib library, Connection conn) {
	conn1 = conn;
// Cleans the screen, preparing to be filled again
	library.frame.setVisible(false);

	JPanel Wpanel, prompt, ID, buttons;

		TempFrame = new JFrame();
		TempFrame.setSize(400,400);
		Wpanel = new JPanel();
		Wpanel.add(new JLabel("Which textbook (enter ID) would you like to delete?"));
		
		T_ID = new JTextField(20);

		prompt = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

			ID = new JPanel();
			ID.add(new JLabel("ID: "));
			ID.add(T_ID);
			c.gridx = 0;
			c.gridy = 1;
			prompt.add(ID,c);
			
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
			BCont = new JButton("Continue");
			BCont.setPreferredSize(new Dimension(100, 50));
			BCont.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String query1 = "delete from BOOK where BOOK_ID = " +T_ID.getText()+ ";";
				try
				{
					Statement stmt = conn1.createStatement();
					int i = stmt.executeUpdate( query1 ); // do the update
				}
				catch( SQLException ex ) 
				{
					System.out.println( "SQL Exception: " 
						+ ex.getMessage());
					ex.printStackTrace();
				}
				TempFrame.getContentPane().removeAll();
				TempFrame.setVisible(false);
				libs.frame.revalidate();
				libs.frame.repaint();
				libs.frame.setVisible(true);
		}});
			buttons.add(BCont);
			BQuit = new JButton("Quit");
			BQuit.setPreferredSize(new Dimension(100, 50));
			BQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
			buttons.add(BQuit);

		TempFrame.add(Wpanel, BorderLayout.PAGE_START);
		TempFrame.add(prompt, BorderLayout.CENTER);
		TempFrame.add(buttons, BorderLayout.PAGE_END);
		TempFrame.setVisible(true);

		libs = library;
   }



public void viewAuthors(Text_Lib library, Connection conn) {
	conn1 = conn;
// Cleans the screen, preparing to be filled again
	library.frame.setVisible(false);

	JPanel Wpanel, text, buttons;

	TempFrame = new JFrame();
	Wpanel = new JPanel();
	Wpanel.add(new JLabel("Authors in Database"));

	text = new JPanel();
	JTextArea textArea = new JTextArea(50, 10);
	PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
	System.setOut(printStream);
	System.setErr(printStream);
	text.add(textArea);
	TempFrame.add(text, BorderLayout.CENTER);

	String query1 = "select * from AUTHOR";
	try
	{
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( query1 ); // do the query
		ResultSetMetaData md = rs.getMetaData(); // grab the Metadata
		int numcols = md.getColumnCount();
		int totalwidth = 0;
		
		// print header
		for( int i=1; i <= numcols; i++ )
		{
			int width = md.getColumnDisplaySize( i );
			totalwidth += width;
			String fmt = "%" + width + "s";
			System.out.format( fmt, md.getColumnName( i ));
		}
		System.out.println();
		for( int i=0; i < totalwidth; i++ )
			System.out.print( "-" );
		System.out.println();
		
		// print records
		while( rs.next() )
		{
			for( int i=1; i<= numcols; i++ )
			{
				String fldname = md.getColumnName( i );
				int fldtype = md.getColumnType( i );
				String fmt = "%" + md.getColumnDisplaySize( i );
				if( fldtype == Types.INTEGER )
					System.out.format( fmt + "d", rs.getInt( fldname ));
				else
					System.out.format( fmt + "s", rs.getString( fldname ));
			}
			System.out.println();
		}
		rs.close();
	}
	catch( SQLException e ) 
	{
		System.out.println( "SQL Exception: " + e.getMessage());
		e.printStackTrace();
	}

	buttons = new JPanel();
	buttons.setLayout(new FlowLayout());
		BCont = new JButton("Continue");
		BCont.setPreferredSize(new Dimension(100, 50));
		BCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				TempFrame.getContentPane().removeAll();
				TempFrame.setVisible(false);
				libs.frame.revalidate();
				libs.frame.repaint();
				libs.frame.setVisible(true);
			}
		});
		buttons.add(BCont);
		BQuit = new JButton("Quit");
		BQuit.setPreferredSize(new Dimension(100, 50));
		BQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		buttons.add(BQuit);

	TempFrame.add(Wpanel, BorderLayout.PAGE_START);
	TempFrame.add(buttons, BorderLayout.PAGE_END);
	TempFrame.pack();
	TempFrame.setVisible(true);

	libs = library;
   }


public void viewTextbooks(Text_Lib library, Connection conn) { 
// Cleans the screen, preparing to be filled again
	library.frame.setVisible(false);

	JPanel Wpanel, text, buttons;

	TempFrame = new JFrame();
	Wpanel = new JPanel();
	Wpanel.add(new JLabel("Textbooks in Database"));

	text = new JPanel();
	JTextArea textArea = new JTextArea(50, 10);
	PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
	System.setOut(printStream);
	System.setErr(printStream);
	text.add(textArea);
	TempFrame.add(text, BorderLayout.CENTER);

	String query1 = "select * from BOOK";
	try
	{
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( query1 ); // do the query
		ResultSetMetaData md = rs.getMetaData(); // grab the Metadata
		int numcols = md.getColumnCount();
		int totalwidth = 0;
		
		// print header
		for( int i=1; i <= numcols; i++ )
		{
			int width = md.getColumnDisplaySize( i );
			totalwidth += width;
			String fmt = "%" + width + "s";
			System.out.format( fmt, md.getColumnName( i ));
		}
		System.out.println();
		for( int i=0; i < totalwidth; i++ )
			System.out.print( "-" );
		System.out.println();
		
		// print records
		while( rs.next() )
		{
			for( int i=1; i<= numcols; i++ )
			{
				String fldname = md.getColumnName( i );
				int fldtype = md.getColumnType( i );
				String fmt = "%" + md.getColumnDisplaySize( i );
				if( fldtype == Types.INTEGER )
					System.out.format( fmt + "d", rs.getInt( fldname ));
				else
					System.out.format( fmt + "s", rs.getString( fldname ));
			}
			System.out.println();
		}
		rs.close();
	}
	catch( SQLException e ) 
	{
		System.out.println( "SQL Exception: " + e.getMessage());
		e.printStackTrace();
	}

	buttons = new JPanel();
	buttons.setLayout(new FlowLayout());
		BCont = new JButton("Continue");
		BCont.setPreferredSize(new Dimension(100, 50));
		BCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				TempFrame.getContentPane().removeAll();
				TempFrame.setVisible(false);
				libs.frame.revalidate();
				libs.frame.repaint();
				libs.frame.setVisible(true);
			}
		});
		buttons.add(BCont);
		BQuit = new JButton("Quit");
		BQuit.setPreferredSize(new Dimension(100, 50));
		BQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}});
		buttons.add(BQuit);

	TempFrame.add(Wpanel, BorderLayout.PAGE_START);
	TempFrame.add(buttons, BorderLayout.PAGE_END);
	TempFrame.pack();
	TempFrame.setVisible(true);

	libs = library;	
   }


// Resets output to go in JPanel, as opposed to terminal. 
   public class CustomOutputStream extends OutputStream {
	    private JTextArea textArea;
	     
	    public CustomOutputStream(JTextArea textArea) {
		this.textArea = textArea;
	    }
	     
	    @Override
	    public void write(int b) throws IOException {
		// redirects data to the text area
		textArea.append(String.valueOf((char)b));
		// scrolls the text area to the end of data
		textArea.setCaretPosition(textArea.getDocument().getLength());
	    }
   }

}

