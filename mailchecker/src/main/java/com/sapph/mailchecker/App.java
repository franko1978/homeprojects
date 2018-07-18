package com.sapph.mailchecker;

import java.awt.*;
import java.util.Calendar;

import javafx.scene.input.KeyCode;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws AWTException, InterruptedException {
        App app = new App();
        app.startMoving(60);

    }
    public void startMoving(int howLongInMinutes) throws AWTException, InterruptedException {
        Calendar timeToStop = Calendar.getInstance();
        timeToStop.add(Calendar.MINUTE, howLongInMinutes);
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
            public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

            }

            public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
                if(nativeKeyEvent.getKeyCode()==16){
                    System.exit(0);

                }
            }

            public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

            }
        });
        while(Calendar.getInstance().before(timeToStop)) {
            moveMouse(randomizer(), randomizer());
            Thread.sleep(randomizer()*100);
        }

    }
    public void moveMouse(int x, int y) throws AWTException{
        Robot robot = new Robot();
        robot.mouseMove(x, y);
    }
    public int randomizer() {
        return (int) (Math.random()*1000);
    }
}
