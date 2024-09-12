package Tugas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField display = new JTextField();
    JButton[] numButtons = new JButton[10];
    JButton btnAdd, btnSub, btnMul, btnDiv, btnEqual, btnClear, btnDelete, btnDot;

    String operator = "";
    double num1 = 0, num2 = 0;

    public Calculator() {
        setSize(400, 600);
        setLocationRelativeTo(this);
        setTitle(">> Calculator Verly <<");

        display.setBounds(50, 25, 290, 50);
        display.setEditable(false);

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
        }

        int x = 50, y = 220;
        for (int i = 1; i <= 9; i++) {
            numButtons[i].setBounds(x, y, 70, 70);
            x += 80;
            if (i % 3 == 0) {
                x = 50;
                y += 80;
            }
        }

        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnMul = new JButton("X");
        btnDiv = new JButton("/");
        btnEqual = new JButton("=");
        btnClear = new JButton("C");
        btnDelete = new JButton("Del");
        btnDot = new JButton(".");

        btnAdd.setBounds(50, 160, 90, 50);
        btnSub.setBounds(150, 160, 90, 50);
        btnMul.setBounds(250, 160, 90, 50);
        btnDiv.setBounds(290, 220, 50, 230);
        btnClear.setBounds(290, 100, 50, 50);
        btnDelete.setBounds(50, 100, 230, 50);
        numButtons[0].setBounds(50, y + 5, 110, 50);
        btnDot.setBounds(170, y + 5, 50, 50);
        btnEqual.setBounds(230, y + 5, 110, 50);

        getContentPane().setLayout(null);
        getContentPane().add(display);
        for (int i = 0; i < 10; i++) {
            getContentPane().add(numButtons[i]);
        }
        getContentPane().add(btnAdd);
        getContentPane().add(btnSub);
        getContentPane().add(btnMul);
        getContentPane().add(btnDiv);
        getContentPane().add(btnEqual);
        getContentPane().add(btnClear);
        getContentPane().add(btnDelete);
        getContentPane().add(btnDot);

        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        btnEqual.addActionListener(this);
        btnClear.addActionListener(this);
        btnDelete.addActionListener(this);
        btnDot.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                display.setText(display.getText() + i);
            }
        }
        if (e.getSource() == btnDot) {
            display.setText(display.getText() + ".");
        }
        if (e.getSource() == btnAdd) {
            num1 = Double.parseDouble(display.getText());
            operator = "+";
            display.setText("");
        }
        if (e.getSource() == btnSub) {
            num1 = Double.parseDouble(display.getText());
            operator = "-";
            display.setText("");
        }
        if (e.getSource() == btnMul) {
            num1 = Double.parseDouble(display.getText());
            operator = "X";
            display.setText("");
        }
        if (e.getSource() == btnDiv) {
            num1 = Double.parseDouble(display.getText());
            operator = "/";
            display.setText("");
        }
        if (e.getSource() == btnEqual) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    display.setText(String.valueOf(num1 + num2));
                    break;
                case "-":
                    display.setText(String.valueOf(num1 - num2));
                    break;
                case "X":
                    display.setText(String.valueOf(num1 * num2));
                    break;
                case "/":
                    if (num2 != 0) {
                        display.setText(String.valueOf(num1 / num2));
                    } else {
                        display.setText("Error");
                    }
                    break;
            }
        }
        if (e.getSource() == btnClear) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
        }
        if (e.getSource() == btnDelete) {
            String currentText = display.getText();
            if (currentText.length() > 0) {
                display.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
