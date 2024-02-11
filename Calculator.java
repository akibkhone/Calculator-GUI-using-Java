
// Importing necessary packages


import javax.swing.*; // Provides GUI components
import java.awt.*; // Provides classes for creating GUI
import java.awt.event.ActionEvent; // Provides events for GUI components
import java.awt.event.ActionListener; // Provides listener interfaces for GUI events

// Calculator class implementing ActionListener interface
public class Calculator implements ActionListener
{

	JFrame frame; // Frame for the calculator
	JTextField textField; // Text field to display input and output
	JButton[] numberButtons = new JButton[10]; // Array of number buttons
	JButton[] functionButtons = new JButton[9]; // Array of function buttons (+, -, *, /, ., =, Delete, Clear, (-))
	JButton addButton, subButton, mulButton, divButton; // Buttons for basic arithmetic operations
	JButton decButton, equButton, delButton, clrButton, negButton; // Buttons for decimal, equal, delete, clear, and
																																	// negation
	JPanel panel; // Panel to hold the buttons

	Font myFont = new Font("Ink Free", Font.BOLD, 24); // Font for buttons and text field

	double num1 = 0, num2 = 0, result = 0; // Variables to hold operands and result
	char operator; // Variable to hold the operation to be performed

	// Constructor to initialize the calculator
	public Calculator()
	{
		// Creating and configuring the frame
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 540);
		frame.setLayout(null);

		// Creating and configuring the text field
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(false);

		// Creating buttons for basic arithmetic operations
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");

		// Assigning buttons to the functionButtons array
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		// Adding action listeners, setting font, and disabling focus for function
		// buttons
		for (int i = 0; i < 9; i++)
		{
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}

		// Creating number buttons and configuring them
		for (int i = 0; i < 10; i++)
		{
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}

		// Creating the panel and configuring its layout
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));

		// Adding buttons to the panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

		// Configuring positions for special buttons
		negButton.setBounds(50, 430, 80, 50);
		delButton.setBounds(135, 430, 120, 50);
		clrButton.setBounds(260, 430, 100, 50);

		// Adding components to the frame
		frame.add(panel);
		frame.add(negButton);
		frame.add(clrButton);
		frame.add(delButton);
		frame.add(textField);
		frame.setVisible(true);
	}

	// Main method to instantiate the calculator
	public static void main(String[] args)
	{
		Calculator calculator = new Calculator();
	}

	// ActionPerformed method to handle button clicks
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Handling number button clicks
		for (int i = 0; i < 10; i++)
		{
			if (e.getSource() == numberButtons[i])
			{
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		// Handling decimal button click
		if (e.getSource() == decButton)
		{
			textField.setText(textField.getText().concat("."));
		}
		// Handling arithmetic operation button clicks
		if (e.getSource() == addButton || e.getSource() == subButton || e.getSource() == mulButton
				|| e.getSource() == divButton)
		{
			num1 = Double.parseDouble(textField.getText());
			operator = e.getActionCommand().charAt(0);
			textField.setText("");
		}
		// Handling equal button click
		if (e.getSource() == equButton)
		{
			num2 = Double.parseDouble(textField.getText());
			switch (operator)
			{
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		// Handling clear button click
		if (e.getSource() == clrButton)
		{
			textField.setText("");
		}
		// Handling delete button click
		if (e.getSource() == delButton)
		{
			String string = textField.getText();
			textField.setText("");
			for (int i = 0; i < string.length() - 1; i++)
			{
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
		// Handling negation button click
		if (e.getSource() == negButton)
		{
			double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
	}
}