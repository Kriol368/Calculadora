import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JPanel root;
    private JPanel Cabecera;
    private JButton btnReset;
    private JLabel lblDisplay;
    private JPanel Botonera;
    private JButton btn7;
    private JButton btn4;
    private JButton btn1;
    private JButton btnPoint;
    private JButton btn8;
    private JButton btn9;
    private JButton btnDiv;
    private JButton btn5;
    private JButton btn6;
    private JButton btnMult;
    private JButton btnRes;
    private JButton btnSum;
    private JButton btn3;
    private JButton btn2;
    private JButton btn0;
    private JButton btnResult;

    public Calculadora() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblDisplay.setText("");
            }
        });
        ActionListener listenerDigitos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = lblDisplay.getText() + ((JButton) e.getSource()).getText();
                lblDisplay.setText(texto);
            }
        };
        btn7.addActionListener(listenerDigitos);
        btn4.addActionListener(listenerDigitos);
        btn1.addActionListener(listenerDigitos);
        btnPoint.addActionListener(listenerDigitos);
        btn8.addActionListener(listenerDigitos);
        btn9.addActionListener(listenerDigitos);
        btn5.addActionListener(listenerDigitos);
        btn6.addActionListener(listenerDigitos);
        btn3.addActionListener(listenerDigitos);
        btn2.addActionListener(listenerDigitos);
        btn0.addActionListener(listenerDigitos);
        ActionListener listenerOperaciones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resutado = calcular(lblDisplay.getText());
                lblDisplay.setText(resutado);
                if (e.getSource() != btnResult) {
                    String texto = lblDisplay.getText() + ((JButton) e.getSource()).getText();
                    lblDisplay.setText(texto);
                }
            }
        };
        btnDiv.addActionListener(listenerOperaciones);
        btnMult.addActionListener(listenerOperaciones);
        btnRes.addActionListener(listenerOperaciones);
        btnSum.addActionListener(listenerOperaciones);
        btnResult.addActionListener(listenerOperaciones);
    }

    public String calcular(String operacion) {
        String resultado;
        String[] ops = operacion.split("[+\\-x/]");
        if (ops.length == 1) {
            resultado = ops[0];
        }else {
            float v1 = Float.parseFloat(ops[0]);
            float v2 = Float.parseFloat(ops[1]);
            float r;
            if (operacion.contains("+")){
                r = v1 + v2;
            }else if (operacion.contains("-")){
                r = v1 - v2;
            } else if (operacion.contains("x")) {
                r = v1 * v2;
            }else  {
                r = v1 / v2;
            }
            resultado = String.valueOf(r);
        }
        return resultado;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
