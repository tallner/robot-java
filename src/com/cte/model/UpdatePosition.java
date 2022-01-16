//Calculates the new position for the robot
package com.cte.model;

public class UpdatePosition {
    public static Robot getNewPosition(Robot robot, String movementPattern) {

        //get start position for this movement
        //get input values
        String inputStartDir = robot.getDirection().toUpperCase();
        int maxX = robot.getSizeX();
        int maxY = robot.getSizeY();
        int currentX = robot.getPositionX();
        int currentY = robot.getPositionY();

        int currentDir = 0;
        int turnLeft = 270;
        int turnRight = 90;
        int dirNorth = 0;
        int dirEast = 90;
        int dirSouth = 180;
        int dirWest = 270;


        //translate start direction to degrees
        if (inputStartDir.equals("N")) currentDir = dirNorth;
        else if (inputStartDir.equals("S")) currentDir = dirSouth;
        else if (inputStartDir.equals("E")) currentDir = dirEast;
        else if (inputStartDir.equals("W")) currentDir = dirWest;

        //loop through the movement pattern from the user
        for (char move : movementPattern.toUpperCase().toCharArray()) {
            if (move == 'L') currentDir += turnLeft;
            else if (move == 'R') currentDir += turnRight;
            else if (move == 'F') {
                switch (currentDir) {
                    //Go north
                    case 0 -> {currentY += 1;}

                    //Go east
                    case 90 -> {currentX += 1;}

                    //Go south
                    case 180 -> {currentY -= 1;}

                    //Go west
                    case 270 -> {currentX -= 1;}

                    //Something went wrong
                    default -> System.out.println("");
                }
            }

            //check limits
            if (currentDir >= 360) currentDir = currentDir - 360; //loop around when exceeding 360

            if ((currentY >= maxY) || (currentY < 0)|| (currentX >= maxX) || (currentX < 0)) {
                System.out.println("Movement out of range");
              //  System.out.println("Xposition :" + currentX+ "  Yposition: "+currentY);
                //keep current value
                currentX = robot.getPositionX();
                currentY = robot.getPositionY();
                break;
            }
        }

        //translate new direction to E S W N
        if(currentDir == dirNorth) inputStartDir="N";
        else if(currentDir == dirEast) inputStartDir="E";
        else if(currentDir == dirSouth) inputStartDir="S";
        else if(currentDir == dirWest) inputStartDir="W";

        //update the robots position
        robot.setPositionX(currentX);
        robot.setPositionY(currentY);
        robot.setDirection(inputStartDir);

        return robot;
    }
}
