/*

	Main.java

	Kendra Callwood
	12/10/2015

*/

import java.io.*; 
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
import java.lang.Object;
import javax.swing.*;
import java.util.Vector;

public class Text_Lib implements ActionListener{
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/Textbooks";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
	
   private static Connection conn = null;

   JFrame frame;
   JButton BCont, BQuit;
   JButton addAuth, addTxt, seeTxt, seeAuth, deleteAuth, deleteTxt;
   static boolean done = false;

   Vector<String> results = new Vector<String>();
   static Text_Lib library;
   Screen screen;


    public static void main(String args []) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch( Exception e ){
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			library = new Text_Lib(conn);

			do {
			} while (!done);

			conn.close();
			System.out.println("Connection closed.");
			System.exit(0);

	       } catch (SQLException ex) {
		   // handle exceptions
		   System.out.println("SQLException: " + ex.getMessage()); 
		   System.out.println("SQLState: "     + ex.getSQLState()); 
		   System.out.println("VendorError: "  + ex.getErrorCode()); 
	       } // end catch

    }



    public Text_Lib(Connection conn){

	screen = new Screen();

// Initializes the frame. Same frame will be used throughout, though contents change 
	frame = new JFrame("Textbook Library");
	frame.setSize(400,400);
	frame.setLayout(new BorderLayout());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Initial screen to determine what the user wants to do 
	JPanel buttongroup = new JPanel();

	seeTxt = new JButton("View Textbooks");
	seeTxt.addActionListener(this);
	buttongroup.add(seeTxt);

	seeAuth = new JButton("View Authors");
	seeAuth.addActionListener(this);
	buttongroup.add(seeAuth);

/*	JButton seePub = new JButton("View Publishers");
	seePub.addActionListener(this);
	buttongroup.add(seePub);

	JButton seeSubj = new JButton("View Subjects");
	seeSubj.addActionListener(this);
	buttongroup.add(seeSubj);*/

	addTxt = new JButton("Add Textbook");
	addTxt.addActionListener(this);
	buttongroup.add(addTxt);

	addAuth = new JButton("Add Author");
	addAuth.addActionListener(this);
	buttongroup.add(addAuth);

	deleteTxt = new JButton("Delete Textbook");
	deleteTxt.addActionListener(this);
	buttongroup.add(deleteTxt);

	deleteAuth = new JButton("Delete Author");
	deleteAuth.addActionListener(this);
	buttongroup.add(deleteAuth);

/*	JButton addCmt = new JButton("Add Comment");
	addCmt.addActionListener(this);
	buttongroup.add(addCmt);

	JButton addRte = new JButton("Add Rating");
	addRte.addActionListener(this);
	buttongroup.add(addRte);*/


	frame.add(buttongroup, BorderLayout.CENTER);
	frame.setVisible(true);

   }

   
   public void actionPerformed(ActionEvent e){
		Object b = e.getSource();
		if (b == addAuth){
			screen.addAuthor(library, conn);	
		}
		else if (b == deleteAuth){
			screen.deleteAuthor(library, conn);
		}
		else if (b == addTxt){
			screen.addTextbook(library, conn);
		}
		else if (b == deleteTxt){
			screen.deleteTextbook(library, conn);
		}
		else if (b == seeTxt){
			screen.viewTextbooks(library, conn);
		}
		else if (b == seeAuth){
			screen.viewAuthors(library, conn);
		}
   }

}

