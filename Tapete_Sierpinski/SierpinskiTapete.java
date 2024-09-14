import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class SierpinskiTapete extends JPanel {
    int nivel_de_recursividad = 5;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal - Tapete de Sierpinski");
        SierpinskiTapete panel = new SierpinskiTapete();
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50, y = 50, size = 500;
        drawSierpinskiCarpet(g, x, y, size, nivel_de_recursividad);
    }

    private void drawSierpinskiCarpet(Graphics g, int x, int y, int size, int level) {
        if (level == 0) {
            g.fillRect(x, y, size, size);
        } else {
            int newSize = size / 3;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (row == 1 && col == 1) continue;
                    drawSierpinskiCarpet(g, x + col * newSize, y + row * newSize, newSize, level - 1);
                }
            }
        }
    }
}
