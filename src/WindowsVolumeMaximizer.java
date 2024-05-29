import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WindowsVolumeMaximizer implements Runnable{
    public static void main(String[] args) {
        maximizeWindowsVolume();
    }

    public static void maximizeWindowsVolume() {
        try {
            // 执行 nircmd 命令将系统音量设置为最大
            Process process = Runtime.getRuntime().exec("nircmd.exe mutesysvolume 0");
             process = Runtime.getRuntime().exec("nircmd.exe setsysvolume 65535");
            process.waitFor();
            System.out.println("Windows volume set to maximum.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            maximizeWindowsVolume();
        }
    }
}