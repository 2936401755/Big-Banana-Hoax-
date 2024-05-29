import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GIFPlayer extends JFrame implements Runnable{

    public GIFPlayer() {
        setTitle("江哥出品,必属精品");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        this.setVisible(true);
        // 加载 GIF 文件
        ImageIcon icon = new ImageIcon("1.gif");

        // 创建 JLabel，并设置 GIF 图片
        JLabel label = new JLabel(icon);

        // 设置 JLabel 在窗口中居中显示
        add(label, BorderLayout.CENTER);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        double x=screenSize.getWidth();
        double y=screenSize.getHeight();
        Random random=new Random();
        setLocation(random.nextInt((int) x),random.nextInt((int) y));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GIFPlayer gifPlayer = new GIFPlayer();

        });
    }

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            SwingUtilities.invokeLater(() -> {
                GIFPlayer gifPlayer = new GIFPlayer();

            });
        }
    }
}