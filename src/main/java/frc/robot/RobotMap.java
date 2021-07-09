package frc.robot;

public class RobotMap {
    public interface CAN {
        int rightTalon = 1;
        int leftTalon = 2;
        int shootTalon = 5;
    }

    public interface PWM {
        int rightVictor = 1;
        int leftVictor = 0;
        int shootVictor = 6;
    }
}
