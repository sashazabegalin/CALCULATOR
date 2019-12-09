import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener{
    static JFrame f;
    static Panel gridpan, flowpan; //declare 2 panels
    static Button zero, one, two, three, four, five, six, seven, eight, nine, dot, clear, eqs, div, add, sub, mult; //declare all your buttons
    static JTextField message; //declare your button;
    
    static JLabel display; //declare your label that displays all the numbers;
    
    String s0, s1, s2;
    
    public void createGUI(){	
        //create first panel
        flowpan = new Panel();
        flowpan.setLayout(new FlowLayout());
        
        //create new textfield and add it to the panel
        
        message = new JTextField("", 11);
        message.setEditable(false);
        
        flowpan.add(message);
        //create clear button and add to panel
        clear = new Button("C");
        flowpan.add(clear);
        //create label and add to panel
        display = new JLabel("   ");
        flowpan.add(display);

        
        
        //create a new panel with gridlayout
        gridpan = new Panel();
        gridpan.setLayout(new GridLayout(4,4));
        //add all buttons to the panel
        zero = new Button("0");
        one = new Button("1");
        two = new Button("2");
        three = new Button("3");
        four = new Button("4");
        five = new Button("5");
        six = new Button("6");
        seven = new Button("7");
        eight = new Button("8");
        nine = new Button("9");
        dot = new Button(".");
        eqs = new Button("=");
        div = new Button("/");
        sub = new Button("-");
        add = new Button("+");
        mult = new Button("*");
        
        gridpan.add(zero);
        gridpan.add(one);
        gridpan.add(two);
        gridpan.add(three);
        gridpan.add(four);
        gridpan.add(five);
        gridpan.add(six);
        gridpan.add(seven);
        gridpan.add(eight);
        gridpan.add(nine);
        gridpan.add(dot);
        gridpan.add(eqs);
        gridpan.add(add);
        gridpan.add(sub);
        gridpan.add(mult);
        gridpan.add(div);
        
        //add both panels to frame
         add(gridpan, BorderLayout.CENTER);
         add(flowpan, BorderLayout.SOUTH);
    }
    
    public void addListeners(){
        //add actionlistener to all number buttons
        
        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        dot.addActionListener(this);
        
		
      //operators portion
       clear.addActionListener(this);
       eqs.addActionListener(this);
       div.addActionListener(this);
       add.addActionListener(this);
       sub.addActionListener(this);
       mult.addActionListener(this);      
    }
    
    public Calculator(){
		//call the above methods to setup your calculator
      super();
      createGUI();
      addListeners();
      s0 = s1 = s2 = ""; 
      setTitle("Calculator");
      setSize(600,400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
     }

    public void actionPerformed(ActionEvent e){
			//gets the "string" from the button clicked
         String s = e.getActionCommand(); 
  
        // if the value is a number 
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') { 
            // if operand is present then add to second no 
            if (!s1.equals("")) 
                s2 = s2 + s; 
            else
                s0 = s0 + s; 
  
            // set the value of text 
            message.setText(s0 + s1 + s2); 
        } 
        else if (s.charAt(0) == 'C') { 
            // clear the one letter 
            s0 = s1 = s2 = ""; 
  
            // set the value of text 
            message.setText(s0 + s1 + s2); 
        } 
        else if (s.charAt(0) == '=') { 
  
            double total; 
  
            // store the value in 1st 
            if (s1.equals("+")) 
                total = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
            else if (s1.equals("-")) 
                total = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
            else if (s1.equals("/")) 
                total = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
            else
                total = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
  
            // set the value of text 
            message.setText(s0 + s1 + s2 + "=" + total); 
  
            // convert it to string 
            s0 = Double.toString(total); 
  
            s1 = s2 = ""; 
        } 
        else { 
            // if there was no operand 
            if (s1.equals("") || s2.equals("")) 
                s1 = s; 
            // else evaluate 
            else { 
                double total; 
  
                // store the value in 1st 
                if (s1.equals("+")) 
                    total = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
                else if (s1.equals("-")) 
                    total = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
                else if (s1.equals("/")) 
                    total = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
                else
                    total = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
  
                // convert it to string 
                s0 = Double.toString(total); 
  
                // place the operator 
                s1 = s; 
  
                // make the operand blank 
                s2 = ""; 
            } 
  
            // set the value of text 
            message.setText(s0 + s1 + s2); 
        } 
    }        
    

    public static void main(String[] args){
        //create calculator object
        Calculator app = new Calculator();
    }
}

