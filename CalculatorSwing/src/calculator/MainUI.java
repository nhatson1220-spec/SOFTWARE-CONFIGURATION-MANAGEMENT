import javax.swing.*;
import java.awt.event.*;

public class MainUI extends JFrame {

    private JTextField txtA, txtB, txtKetQua;
    private JButton btnCong, btnTru, btnNhan, btnChia;

    public MainUI() {
        setTitle("Máy tính đơn giản");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblA = new JLabel("Số A:");
        lblA.setBounds(20, 20, 80, 25);
        add(lblA);

        txtA = new JTextField();
        txtA.setBounds(100, 20, 150, 25);
        add(txtA);

        JLabel lblB = new JLabel("Số B:");
        lblB.setBounds(20, 60, 80, 25);
        add(lblB);

        txtB = new JTextField();
        txtB.setBounds(100, 60, 150, 25);
        add(txtB);

        btnCong = new JButton("+");
        btnCong.setBounds(20, 100, 50, 30);
        add(btnCong);

        btnTru = new JButton("-");
        btnTru.setBounds(80, 100, 50, 30);
        add(btnTru);

        btnNhan = new JButton("*");
        btnNhan.setBounds(140, 100, 50, 30);
        add(btnNhan);

        btnChia = new JButton("/");
        btnChia.setBounds(200, 100, 50, 30);
        add(btnChia);

        JLabel lblKQ = new JLabel("Kết quả:");
        lblKQ.setBounds(20, 150, 80, 25);
        add(lblKQ);

        txtKetQua = new JTextField();
        txtKetQua.setBounds(100, 150, 150, 25);
        txtKetQua.setEditable(false);
        add(txtKetQua);

        // Xử lý sự kiện
        btnCong.addActionListener(e -> tinhToan("cong"));
        btnTru.addActionListener(e -> tinhToan("tru"));
        btnNhan.addActionListener(e -> tinhToan("nhan"));
        btnChia.addActionListener(e -> tinhToan("chia"));
    }

    private void tinhToan(String phep) {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double kq = 0;

            switch (phep) {
                case "cong":
                    kq = new Cong().tinh(a, b);
                    break;
                case "tru":
                    kq = new Tru().tinh(a, b);
                    break;
                case "nhan":
                    kq = new Nhan().tinh(a, b);
                    break;
                case "chia":
                    kq = new Chia().tinh(a, b);
                    break;
            }

            txtKetQua.setText(String.valueOf(kq));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new MainUI().setVisible(true);
    }
}