//Robot controller controls the data flow
package com.cte.controller;
import com.cte.model.Robot;
import com.cte.model.UpdatePosition;
import com.cte.view.RobotView;

public class RobotController {
    private Robot model;
    private RobotView view;
    private String movementPattern;

    public RobotController(Robot model, RobotView view){
        this.model = model;
        this.view = view;
    }

    public void setRobotPosX(int x){
        model.setPositionX(x);
    }
    public int getRobotPosX() {
        return this.model.getPositionX();
    }

    public void setRobotPosY(int y){
        model.setPositionY(y);
    }
    public int getRobotPosY(){
        return this.model.getPositionY();
        }

    public void setRobotDir(String dir){
        model.setDirection(dir);
    }
    public String getRobotDir(){
        return this.model.getDirection();
    }

    public void setSizeX(int sizeX){
        model.setSizeX(sizeX);
    }
    public int getSizeX(){
        return this.model.getSizeX();
    }

    public void setSizeY(int sizeY){
        model.setSizeY(sizeY);
    }
    public int getSizeY(){
        return this.model.getSizeY();
    }

    public void setMovementPattern(String movementPattern) {
        this.movementPattern = movementPattern;
    }


    public void updatePosition(String movementPattern){
        UpdatePosition.getNewPosition(this.model, movementPattern);
    }
    public void updateView(){
        view.printRobotPosition(model.getPositionX(), model.getPositionY(), model.getDirection());
    }


}
