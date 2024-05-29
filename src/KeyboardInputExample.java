import java.awt.*;
import java.awt.event.*;

public class KeyboardInputExample implements Runnable{
//    public static void main(String[] args) {
//        // 创建键盘事件监听器
//        KeyAdapter keyAdapter = new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                // 检测按下的键是否为指定的键
//                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//                    System.out.println("Exiting program...");
//                    System.exit(0);
//                }
//            }
//        };
//
//        // 添加键盘事件监听器到默认焦点组件
//        java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
//            @Override
//            public boolean dispatchKeyEvent(KeyEvent e) {
//                if (e.getID() == KeyEvent.KEY_PRESSED) {
//                    keyAdapter.keyPressed(e);
//                }
//                return false;
//            }
//        });
//
//        // 循环等待
//        while (true) {
//            // 你的程序代码
//            System.out.println("Press ESC to exit.");
//            try {
//                Thread.sleep(1000); // 休眠1秒钟
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }

    @Override
    public void run() {
        // 创建键盘事件监听器
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 检测按下的键是否为指定的键
                if (e.getKeyCode() == KeyEvent.VK_F12) {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
            }
        };

        // 添加键盘事件监听器到默认焦点组件
        java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    keyAdapter.keyPressed(e);
                }
                return false;
            }
        });

        // 循环等待
        while (true) {
            // 你的程序代码
            System.out.println("Press ESC to exit.");
            try {
                Thread.sleep(1000); // 休眠1秒钟
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}