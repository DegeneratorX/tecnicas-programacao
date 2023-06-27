package trabalho_final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphInterface extends JFrame {

    public GraphInterface() {
        setTitle("Graph Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JTextArea infoTextArea = new JTextArea();
        infoTextArea.setEditable(false);
        infoTextArea.setMargin(new Insets(10, 10, 10, 10));

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JScrollPane(infoTextArea), BorderLayout.SOUTH);
        contentPane.add(new JLabel("Click on a column to display statistics."), BorderLayout.NORTH);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


            }
        });
    }
    public void display() {
        setVisible(true);
    }