package calculatorapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalculatorApplication implements ActionListener {

    double num1 = 0, num2 = 0;
    int calculation;
    double result;
    JFrame frame = new JFrame("Calculator");
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JRadioButton onRadioButton = new JRadioButton("on");
    JRadioButton offRadioButton = new JRadioButton("off");
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonDot = new JButton(".");
    JButton buttonClear = new JButton("C");
    JButton buttonDelete = new JButton("DEL");
    JButton buttonEquals = new JButton("=");
    JButton buttonMul = new JButton("X");
    JButton buttonDiv = new JButton("/");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonSquare = new JButton("x\u00B2");
    JButton buttonReciprocalt = new JButton("1/x");
    JButton buttonSqrt = new JButton("\u221A");

    // Konstanta warna untuk tampilan modern
    private static final Color COLOR_PRIMARY = new Color(40, 40, 40); // Abu-abu gelap
    private static final Color COLOR_SECONDARY = new Color(50, 50, 50); // Abu-abu sedikit lebih terang
    private static final Color COLOR_ACCENT = new Color(239, 188, 2); // Kuning terang
    private static final Color COLOR_TEXT = Color.WHITE;

    CalculatorApplication() {
        prepareGui();
        addComponents();
        addActionEventListener();
    }

    public void prepareGui() {
        frame.setSize(305, 510);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(COLOR_PRIMARY);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponents() {
        label.setBounds(250, 0, 50, 50);
        label.setForeground(COLOR_ACCENT); // Warna teks label
        label.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(label);

        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setBackground(COLOR_SECONDARY); // Warna latar belakang textField
        textField.setForeground(COLOR_TEXT); // Warna teks textField
        textField.setCaretColor(COLOR_TEXT); // Warna kursor textField
        frame.add(textField);

        onRadioButton.setBounds(10, 95, 60, 40);
        onRadioButton.setSelected(true);
        onRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        onRadioButton.setBackground(COLOR_PRIMARY);
        onRadioButton.setForeground(COLOR_TEXT);
        onRadioButton.setFocusable(false);
        frame.add(onRadioButton);

        offRadioButton.setBounds(10, 120, 60, 40);
        offRadioButton.setSelected(false);
        offRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        offRadioButton.setBackground(COLOR_PRIMARY);
        offRadioButton.setForeground(COLOR_TEXT);
        offRadioButton.setFocusable(false);
        frame.add(offRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onRadioButton);
        buttonGroup.add(offRadioButton);

        // Tombol Angka
        button7.setBounds(10, 230, 60, 40);
        applyStyleToButton(button7);
        frame.add(button7);

        button8.setBounds(80, 230, 60, 40);
        applyStyleToButton(button8);
        frame.add(button8);

        button9.setBounds(150, 230, 60, 40);
        applyStyleToButton(button9);
        frame.add(button9);

        button4.setBounds(10, 290, 60, 40);
        applyStyleToButton(button4);
        frame.add(button4);

        button5.setBounds(80, 290, 60, 40);
        applyStyleToButton(button5);
        frame.add(button5);

        button6.setBounds(150, 290, 60, 40);
        applyStyleToButton(button6);
        frame.add(button6);

        button1.setBounds(10, 350, 60, 40);
        applyStyleToButton(button1);
        frame.add(button1);

        button2.setBounds(80, 350, 60, 40);
        applyStyleToButton(button2);
        frame.add(button2);

        button3.setBounds(150, 350, 60, 40);
        applyStyleToButton(button3);
        frame.add(button3);

        button0.setBounds(10, 410, 130, 40);
        applyStyleToButton(button0);
        frame.add(button0);

        buttonDot.setBounds(150, 410, 60, 40);
        applyStyleToButton(buttonDot);
        frame.add(buttonDot);

        // Tombol Operasi
        buttonEquals.setBounds(220, 350, 60, 100);
        applyStyleToButton(buttonEquals);
        frame.add(buttonEquals);

        buttonPlus.setBounds(220, 290, 60, 40);
        applyStyleToButton(buttonPlus);
        frame.add(buttonPlus);

        buttonMinus.setBounds(220, 170, 60, 40);
        applyStyleToButton(buttonMinus);
        frame.add(buttonMinus);

        buttonMul.setBounds(220, 230, 60, 40);
        applyStyleToButton(buttonMul);
        frame.add(buttonMul);

        buttonDiv.setBounds(220, 110, 60, 40);
        applyStyleToButton(buttonDiv);
        frame.add(buttonDiv);

        // Tombol Fungsi Khusus
        buttonSqrt.setBounds(10, 170, 60, 40);
        applyStyleToButton(buttonSqrt);
        frame.add(buttonSqrt);

        buttonSquare.setBounds(80, 170, 60, 40);
        applyStyleToButton(buttonSquare);
        frame.add(buttonSquare);

        buttonReciprocalt.setBounds(150, 170, 60, 40);
        applyStyleToButton(buttonReciprocalt);
        frame.add(buttonReciprocalt);

        // Tombol Clear dan Delete
        buttonDelete.setBounds(150, 110, 60, 40);
        applyStyleToSpecialButton(buttonDelete);
        frame.add(buttonDelete);

        buttonClear.setBounds(80, 110, 60, 40);
        applyStyleToSpecialButton(buttonClear);
        frame.add(buttonClear);
    }

    // Method untuk menerapkan style pada tombol standar
    private void applyStyleToButton(JButton button) {
        button.setBackground(COLOR_SECONDARY);
        button.setForeground(COLOR_TEXT);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusable(false);
    }

    // Method untuk menerapkan style pada tombol spesial (C, DEL)
    private void applyStyleToSpecialButton(JButton button) {
        button.setBackground(new Color(180, 0, 0)); // Merah tua untuk tombol spesial
        button.setForeground(COLOR_TEXT);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setFocusable(false);
    }

    public void addActionEventListener() {
        onRadioButton.addActionListener(this);
        offRadioButton.addActionListener(this);
        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonDot.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonEquals.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonSquare.addActionListener(this);
        buttonReciprocalt.addActionListener(this);
        buttonSqrt.addActionListener(this);
    }

    public void enable() {
        onRadioButton.setEnabled(false);
        offRadioButton.setEnabled(true);
        textField.setEnabled(true);
        label.setEnabled(true);
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        buttonDot.setEnabled(true);
        buttonClear.setEnabled(true);
        buttonDelete.setEnabled(true);
        buttonEquals.setEnabled(true);
        buttonMul.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonSquare.setEnabled(true);
        buttonReciprocalt.setEnabled(true);
        buttonSqrt.setEnabled(true);
    }

    public void disable() {
        onRadioButton.setEnabled(true);
        offRadioButton.setEnabled(false);
        textField.setEnabled(false);
        label.setEnabled(false);
        button0.setEnabled(false);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
        buttonDot.setEnabled(false);
        buttonClear.setEnabled(false);
        buttonDelete.setEnabled(false);
        buttonEquals.setEnabled(false);
        buttonMul.setEnabled(false);
        buttonDiv.setEnabled(false);
        buttonPlus.setEnabled(false);
        buttonMinus.setEnabled(false);
        buttonSquare.setEnabled(false);
        buttonReciprocalt.setEnabled(false);
        buttonSqrt.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == onRadioButton) {
            enable();
        } else if (source == offRadioButton) {
            disable();
        } else if (source == buttonClear) {
            label.setText("");
            textField.setText("");
        } else if (source == buttonDelete) {
            int length = textField.getText().length();
            int number = length - 1;
            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(number);
                textField.setText(back.toString());
            }
            if (textField.getText().endsWith("")) {
                label.setText("");
            }

        } else if (source == button0) {
            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (source == button1) {
            textField.setText(textField.getText() + "1");
        } else if (source == button2) {
            textField.setText(textField.getText() + "2");
        } else if (source == button3) {
            textField.setText(textField.getText() + "3");
        } else if (source == button4) {
            textField.setText(textField.getText() + "4");
        } else if (source == button5) {
            textField.setText(textField.getText() + "5");
        } else if (source == button6) {
            textField.setText(textField.getText() + "6");
        } else if (source == button7) {
            textField.setText(textField.getText() + "7");
        } else if (source == button8) {
            textField.setText(textField.getText() + "8");
        } else if (source == button9) {
            textField.setText(textField.getText() + "9");
        } else if (source == buttonDot) {
            if (textField.getText().contains(".")) {
                return;
            } else {
                textField.setText(textField.getText() + ".");
            }
        } else if (source == buttonPlus) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 1;
            textField.setText("");
            label.setText(str + "+");
        } else if (source == buttonMinus) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 2;
            textField.setText("");
            label.setText(str + "-");

        } else if (source == buttonMul) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 3;
            textField.setText("");
            label.setText(str + "X");

        } else if (source == buttonDiv) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 4;
            textField.setText("");
            label.setText(str + "/");

        } else if (source == buttonSquare) {
            num1 = Double.parseDouble(textField.getText());
            double square = Math.pow(num1, 2);
            String string = Double.toString(square);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }

        } else if (source == buttonSqrt) {
            num1 = Double.parseDouble(textField.getText()); // Perbaikan: Gunakan Double.parseDouble
            double sqrt = Math.sqrt(num1);
            textField.setText(Double.toString(sqrt));
        } else if (source == buttonReciprocalt) {
            num1 = Double.parseDouble(textField.getText());
            double reciprocalt = 1 / num1;
            String string = Double.toString(reciprocalt);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
        } else if (source == buttonEquals) {
            num2 = Double.parseDouble(textField.getText());

            switch (calculation) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    result = num1 / num2;
                    break;
                default:
                    result = 0; // Menangani kasus jika calculation tidak memiliki nilai yang valid
                    break;
            }
            // Gunakan DecimalFormat untuk tampilan angka yang lebih baik
            DecimalFormat df = new DecimalFormat("#.##########");
            if (Double.toString(result).endsWith(".0")) {
                textField.setText(df.format(result).replace(".0", ""));
            } else {
                textField.setText(df.format(result));
            }
            label.setText("");
            num1 = result;
        }
    }

    public static void main(String[] args) {
        CalculatorApplication calculator = new CalculatorApplication();
    }
}
