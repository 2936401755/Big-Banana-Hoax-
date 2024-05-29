import javax.swing.*;
import java.sql.Time;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.*;
import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new GIFPlayer());
        thread.start();
        Thread thread1=new Thread(new WindowsVolumeMaximizer());
        thread1.start();
        Thread thread2=new Thread(new KeyboardInputExample());
        thread2.start();
        String audioFilePath = "1.wav";

        try {
            // 打开音频文件
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new java.io.File(audioFilePath));

            // 获取音频格式
            AudioFormat format = audioStream.getFormat();

            // 创建数据行信息
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            // 打开数据行并开始播放音频
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            // 读取音频数据并写入数据行
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesRead = 0;
            while ((bytesRead = audioStream.read(buffer, 0, bufferSize)) != -1) {
                line.write(buffer, 0, bytesRead);
            }

            // 停止数据行
            line.drain();
            line.stop();
            line.close();

            // 关闭音频流
            audioStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        while (true){
//            TimeUnit.SECONDS.sleep(1);
//            SwingUtilities.invokeLater(() -> {
//            GIFPlayer gifPlayer = new GIFPlayer();
//
//        });
 //       }


    }
}