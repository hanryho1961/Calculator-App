package professor_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator extends JFrame implements ActionListener{
	private JTextField textField;
	private JButton buttonBack, buttonC, buttonCE;
	private JButton buttonMC, buttonMR, buttonMS, buttonMPlus;
	private JButton button9, button8, button7, button6, button5, button4, button3, button2, button1, button0, buttonSign, buttonDot;
	private JButton buttonDivide, buttonSqrt, buttonMultiply, buttonPercent, buttonAdd, buttonMinus, buttonFraction, buttonEqual;
	private ArrayDeque<Double> numbers;
	private ArrayDeque<String> symbols;
	private int numberOfNumb;
	private Double numbM;
	private boolean equation;
	
	public Calculator() {
		numbers = new ArrayDeque<Double>();
		symbols = new ArrayDeque<String>();
		numberOfNumb = 0;
		numbM = 0.0;
		equation = false;
		
		//----------------------------------------------------------------------------------------------------------------------------
		//JTEXTFIELD
		textField = new JTextField("0");
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setForeground(Color.WHITE);						//Set Font Color
		textField.setBounds(50, 45, 410, 50);						//Set dimension and x, y coordinates for the top left of JText
		textField.setBackground(Color.BLUE);						//Set Background
		textField.setHorizontalAlignment(SwingConstants.RIGHT);		//Align the text to the right
		getContentPane().add(textField); 							//Add JText to Panel
		//----------------------------------------------------------------------------------------------------------------------------
		//BUTTON BACKSPACE
		buttonBack = new JButton("Backspc");
		buttonBack.setForeground(Color.RED);
		buttonBack.setBounds(120, 110, 100, 50);
		buttonBack.addActionListener(this);
		getContentPane().add(buttonBack);
		
		//BUTTON C
		buttonC = new JButton("C");
		buttonC.setForeground(Color.RED);
		buttonC.setBounds(240, 110, 100, 50);
		buttonC.addActionListener(this);
		getContentPane().add(buttonC);
				
		//BUTTON CE
		buttonCE = new JButton("CE");
		buttonCE.setForeground(Color.RED);
		buttonCE.setBounds(360, 110, 100, 50);
		buttonCE.addActionListener(this);
		getContentPane().add(buttonCE);
		
		//----------------------------------------------------------------------------------------------------------------------------
		//BUTTON MC
		buttonMC = new JButton("MC");
		buttonMC.setForeground(Color.RED);
		buttonMC.setBounds(50, 175, 50, 50);
		buttonMC.addActionListener(this);
		getContentPane().add(buttonMC);
		
		//BUTTON MR
		buttonMR = new JButton("MR");
		buttonMR.setForeground(Color.RED);
		buttonMR.setBounds(50, 240, 50, 50);
		buttonMR.addActionListener(this);
		getContentPane().add(buttonMR);
		
		//BUTTON MS
		buttonMS = new JButton("MS");
		buttonMS.setForeground(Color.RED);
		buttonMS.setBounds(50, 305, 50, 50);
		buttonMS.addActionListener(this);
		getContentPane().add(buttonMS);
		
		//BUTTON M+
		buttonMPlus = new JButton("M+");
		buttonMPlus.setForeground(Color.RED);
		buttonMPlus.setBounds(50, 370, 50, 50);
		buttonMPlus.addActionListener(this);
		getContentPane().add(buttonMPlus);
		
		//----------------------------------------------------------------------------------------------------------------------------
		//BUTTON 7
		button7 = new JButton("7");
		button7.setBounds(120, 175, 50, 50);
		button7.addActionListener(this);
		getContentPane().add(button7);
		
		//BUTTON 8
		button8 = new JButton("8");
		button8.setBounds(190, 175, 50, 50);
		button8.addActionListener(this);
		getContentPane().add(button8);
		
		//BUTTON 9
		button9 = new JButton("9");
		button9.setBounds(260, 175, 50, 50);
		button9.addActionListener(this);
		getContentPane().add(button9);
		
		//BUTTON 4
		button4 = new JButton("4");
		button4.setBounds(120, 240, 50, 50);
		button4.addActionListener(this);
		getContentPane().add(button4);
		
		//BUTTON 5
		button5 = new JButton("5");
		button5.setBounds(190, 240, 50, 50);
		button5.addActionListener(this);
		getContentPane().add(button5);
		
		//BUTTON 6
		button6 = new JButton("6");
		button6.setBounds(260, 240, 50, 50);
		button6.addActionListener(this);
		getContentPane().add(button6);
		
		//BUTTON 1
		button1 = new JButton("1");
		button1.setBounds(120, 305, 50, 50);
		button1.addActionListener(this);
		getContentPane().add(button1);
		
		//BUTTON 2
		button2 = new JButton("2");
		button2.setBounds(190, 305, 50, 50);
		button2.addActionListener(this);
		getContentPane().add(button2);
		
		//BUTTON 3
		button3 = new JButton("3");
		button3.setBounds(260, 305, 50, 50);
		button3.addActionListener(this);
		getContentPane().add(button3);
		
		//BUTTON 0
		button0 = new JButton("0");
		button0.setBounds(120, 370, 50, 50);
		button0.addActionListener(this);
		getContentPane().add(button0);
		
		//BUTTON SIGN
		buttonSign = new JButton("+/-");
		buttonSign.setBounds(190, 370, 50, 50);
		buttonSign.addActionListener(this);
		getContentPane().add(buttonSign);
		
		//BUTTON DOT
		buttonDot = new JButton(".");
		buttonDot.setBounds(260, 370, 50, 50);
		buttonDot.addActionListener(this);
		getContentPane().add(buttonDot);
		//----------------------------------------------------------------------------------------------------------------------------
		//BUTTON Divide
		buttonDivide = new JButton("/");
		buttonDivide.setForeground(Color.RED);
		buttonDivide.setBounds(340, 175, 50, 50);
		buttonDivide.addActionListener(this);
		getContentPane().add(buttonDivide);
		
		//BUTTON SQRT
		buttonSqrt = new JButton("sqrt");
		buttonSqrt.setForeground(Color.RED);
		buttonSqrt.setBounds(410, 175, 50, 50);
		buttonSqrt.addActionListener(this);
		getContentPane().add(buttonSqrt);
		
		//BUTTON MULTIPLY
		buttonMultiply = new JButton("*");
		buttonMultiply.setForeground(Color.RED);
		buttonMultiply.setBounds(340, 240, 50, 50);
		buttonMultiply.addActionListener(this);
		getContentPane().add(buttonMultiply);
		
		//BUTTON PERCENT
		buttonPercent = new JButton("%");
		buttonPercent.setForeground(Color.RED);
		buttonPercent.setBounds(410, 240, 50, 50);
		buttonPercent.addActionListener(this);
		getContentPane().add(buttonPercent);
		
		//BUTTON ADD
		buttonAdd = new JButton("+");
		buttonAdd.setForeground(Color.RED);
		buttonAdd.setBounds(340, 305, 50, 50);
		buttonAdd.addActionListener(this);
		getContentPane().add(buttonAdd);
		
		//BUTTON FRACTION
		buttonFraction = new JButton("1/X");
		buttonFraction.setForeground(Color.RED);
		buttonFraction.setBounds(410, 305, 50, 50);
		buttonFraction.addActionListener(this);
		getContentPane().add(buttonFraction);
		
		//BUTTON MINUS
		buttonMinus = new JButton("-");
		buttonMinus.setForeground(Color.RED);
		buttonMinus.setBounds(340, 370, 50, 50);
		buttonMinus.addActionListener(this);
		getContentPane().add(buttonMinus);
		
		//BUTTON EQUAL
		buttonEqual = new JButton("=");
		buttonEqual.setForeground(Color.RED);
		buttonEqual.setBounds(410, 370, 50, 50);
		buttonEqual.addActionListener(this);
		getContentPane().add(buttonEqual);
		
		//----------------------------------------------------------------------------------------------------------------------------
		//JFRAME
		this.setTitle("Calculator");			//Set name for the frame
		this.setSize(510, 500);
		getContentPane().setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button0) {
			if (equation) {
				checkNumber("0");
				return;
			}
			char[] list = textField.getText().toCharArray();
			if (list[0] == '0' && list.length == 1) {
				textField.setText("");
			} 
			if (check(textField.getText())) {
				textField.setText(textField.getText() + "0");
			} else {
				textField.setText("0");
			}
		} else if (e.getSource() == button1) {
			if (equation) {
				checkNumber("1");
				return;
			}
			char[] list = textField.getText().toCharArray();
			if (list[0] == '0' && list.length == 1) {
				textField.setText("");
			}
			if (check(textField.getText())) {
				textField.setText(textField.getText() + "1");
			} else {
				textField.setText("1");
			}
		} else if (e.getSource() == button2) {
			if (equation) {
				checkNumber("2");
				return;
			}
			char[] list = textField.getText().toCharArray();
			if (list[0] == '0' && list.length == 1) {
				textField.setText("");
			}
			if (check(textField.getText())) {
				textField.setText(textField.getText() + "2");
			} else {
				textField.setText("2");
			}
		} else if (e.getSource() == button3) {
			if (equation) {
				checkNumber("3");
				return;
			}
			char[] list = textField.getText().toCharArray();
			if (list[0] == '0' && list.length == 1) {
				textField.setText("");
			}
			if (check(textField.getText())) {
				textField.setText(textField.getText() + "3");
			} else {
				textField.setText("3");
			}
		} else if (e.getSource() == button4) {
			if (equation) {
				checkNumber("4");
				return;
			}
			char[] list = textField.getText().toCharArray();
			if (list[0] == '0' && list.length == 1) {
				textField.setText("");
			}
			if (check(textField.getText())) {
				textField.setText(textField.getText() + "4");
			} else {
				textField.setText("4");
			}
		} else if (e.getSource() == button5) {
			if (equation) {
				checkNumber("5");
				return;
			}
			char[] list = textField.getText().toCharArray();
			if (list[0] == '0' && list.length == 1) {
				textField.setText("");
			}
			if (check(textField.getText())) {
				textField.setText(textField.getText() + "5");
			} else {
				textField.setText("5");
			}
		} else if (e.getSource() == button6) {
			if (equation) {
				checkNumber("6");
				return;
			}
			char[] list = textField.getText().toCharArray();
			if (list[0] == '0' && list.length == 1) {
				textField.setText("");
			}
			if (check(textField.getText())) {
				textField.setText(textField.getText() + "6");
			} else {
				textField.setText("6");
			}
		} else if (e.getSource() == button7) {
			if (equation) {
				checkNumber("7");
				return;
			}
			char[] list = textField.getText().toCharArray();
			if (list[0] == '0' && list.length == 1) {
				textField.setText("");
			}
			if (check(textField.getText())) {
				textField.setText(textField.getText() + "7");
			} else {
				textField.setText("7");
			}
		} else if (e.getSource() == button8) {
			if (equation) {
				checkNumber("8");
				return;
			}
			char[] list = textField.getText().toCharArray();
			if (list[0] == '0' && list.length == 1) {
				textField.setText("");
			}
			if (check(textField.getText())) {
				textField.setText(textField.getText() + "8");
			} else {
				textField.setText("8");
			}
		} else if (e.getSource() == button9) {
			if (equation) {
				checkNumber("9");
				return;
			}
			char[] list = textField.getText().toCharArray();
			if (list[0] == '0' && list.length == 1) {
				textField.setText("");
			}
			if (check(textField.getText())) {
				textField.setText(textField.getText() + "9");
			} else {
				textField.setText("9");
			}
		} else if (e.getSource() == buttonDot) {
			char[] list = textField.getText().toCharArray();
			int result = 0;
			for (char character : list) {
				if (character == '.') {
					result = 1;
				}
			}
			if (result == 0) {
				textField.setText(textField.getText() + ".");
			}
		} else if (e.getSource() == buttonSign) {
			Double value = Double.parseDouble(textField.getText());
			if (value > 0) {
				value -= (value * 2);
				textField.setText(value.toString());
			} else if (value < 0){
				value += (value * (-2));
				textField.setText(value.toString());
			} else {
				textField.setText(textField.getText());
			}
		} else if (e.getSource() == buttonAdd) {
			numbers.addLast(Double.parseDouble(textField.getText()));
			symbols.addLast("+");
			numberOfNumb++;
			equation = true;
		} else if (e.getSource() == buttonMinus) {
			numbers.addLast(Double.parseDouble(textField.getText()));
			symbols.addLast("-");
			numberOfNumb++;
			equation = true;
		} else if (e.getSource() == buttonMultiply) {
			numbers.addLast(Double.parseDouble(textField.getText()));
			symbols.addLast("*");
			numberOfNumb++;
			equation = true;
		} else if (e.getSource() == buttonDivide) {
			numbers.addLast(Double.parseDouble(textField.getText()));
			symbols.addLast("/");
			numberOfNumb++;
			equation = true;
		} else if (e.getSource() == buttonPercent) {
			Double value = Double.parseDouble(textField.getText());
			value = value / 100;
			textField.setText(value.toString());
		} else if (e.getSource() == buttonSqrt) {
			Double value = Double.parseDouble(textField.getText());
			value = Math.sqrt(value);
			textField.setText(value.toString());
		} else if (e.getSource() == buttonFraction) {
			Double value = Double.parseDouble(textField.getText());
			value = 1/value;
			textField.setText(value.toString());
		} else if (e.getSource() == buttonC) {
			numbers.clear();
			symbols.clear();
			numberOfNumb = 0;
			textField.setText("0");
		} else if (e.getSource() == buttonCE) {
			textField.setText("0");
		} else if (e.getSource() == buttonMC) {
			numbM = 0.0;
		} else if (e.getSource() == buttonMPlus) {
			numbM += Double.parseDouble(textField.getText());
			equation = true;
		} else if (e.getSource() == buttonMR) {
			textField.setText(numbM.toString());
		} else if (e.getSource() == buttonMS) {
			numbM = Double.parseDouble(textField.getText());
			equation = true;
		} else if (e.getSource() == buttonBack) {
			String value = textField.getText();
			if (value.length() == 1) {
				if (value.compareTo("0") != 0) {
					textField.setText("0");
				}
				return;
			}
			value = value.substring(0, value.length() - 1);
			textField.setText(value);
		} else if (e.getSource() == buttonEqual) {
			equation = true;
			if (numbers.isEmpty()) {
				textField.setText(textField.getText());
				return;
			}
			numbers.addLast(Double.parseDouble(textField.getText()));
			Double numb = numbers.pollFirst();
			String sign;
			for (int i = 0; i < numberOfNumb; i++) {
				sign = symbols.pollFirst();
				if (sign.compareToIgnoreCase("+") == 0) {
					numb += numbers.pollFirst();
					textField.setText(numb.toString());
				} else if (sign.compareToIgnoreCase("-") == 0) {
					numb -= numbers.pollFirst();
					textField.setText(numb.toString());
				} else if (sign.compareToIgnoreCase("*") == 0) {
					numb *= numbers.pollFirst();
					textField.setText(numb.toString());
				} else if (sign.compareToIgnoreCase("/") == 0) {
					numb /= numbers.pollFirst();
					textField.setText(numb.toString());
				} 
			}
		}
		
	}
	
	private boolean check(String line) {
		Pattern pattern = Pattern.compile("-[0-9]{1,}|[0-9]{1,}|-");
		Matcher match = pattern.matcher(line);
		if (match.find()) {
			return true;
		}
		return false;
	}
	
	private void checkNumber(String line) {
		textField.setText(line);
		equation = false;
	}
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();
	}

}
