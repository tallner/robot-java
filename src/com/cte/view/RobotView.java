//Collect what is sent to UI
package com.cte.view;

public class RobotView {
    public void printRobotPosition(int x, int y, String direction){
        System.out.println("Robot is at: ");
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
        System.out.println("Direction: " + direction);
    }
}
