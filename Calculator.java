/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField Num1;
    private JTextField Num2;
    private Calculatorr calc;
    private JLabel resultLabel;

    public Calculator() {
        calc = new Calculatorr();
        setTitle("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Num1:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        Num1 = new JTextField(15);
        panel.add(Num1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Num2:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        Num2 = new JTextField(15);
        panel.add(Num2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calc.Add(Num1, Num2);
                displayResult();
            }
        });
        buttonPanel.add(addButton);

        JButton subtractButton = new JButton("Subtract");
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calc.subtract(Num1, Num2);
                displayResult();
            }
        });
        buttonPanel.add(subtractButton);

        JButton divideButton = new JButton("Divide");
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calc.divide(Num1, Num2);
                displayResult();
            }
        });
        buttonPanel.add(divideButton);

        JButton multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calc.multiply(Num1, Num2);
                displayResult();
            }
        });
        buttonPanel.add(multiplyButton);

        gbc.gridy = 3;
        panel.add(buttonPanel, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        resultLabel = new JLabel("Result: ");
        panel.add(resultLabel, gbc);

        add(panel);

        setVisible(true);
    }

    private void displayResult() {
        resultLabel.setText("Result: " + calc.getSum());
        JOptionPane.showMessageDialog(this, "Result: " + calc.getSum());
    }

    public class Calculatorr {
        private int sum;

        public Calculatorr() {
            sum = 0;
        }

        public int getSum() {
            return sum;
        }

        public int Add(JTextField x, JTextField y) {
            int a = Integer.parseInt(x.getText());
            int b = Integer.parseInt(y.getText());
            sum = a + b;
            return sum;
        }

        public int subtract(JTextField x, JTextField y) {
            int a = Integer.parseInt(x.getText());
            int b = Integer.parseInt(y.getText());
            sum = a - b;
            return sum;
        }

        public int divide(JTextField x, JTextField y) {
            int a = Integer.parseInt(x.getText());
            int b = Integer.parseInt(y.getText());
            sum = a / b;
            return sum;
        }

        public int multiply(JTextField x, JTextField y) {
            int a = Integer.parseInt(x.getText());
            int b = Integer.parseInt(y.getText());
            sum = a * b;
            return sum;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
