package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GenericShooter extends SubsystemBase {
    private final SpeedController motor;

    public GenericShooter(SpeedController motor) {
        this.motor = motor;
    }

    public void on(double speed) {
        this.motor.set(speed);
    }

    public void off() {
        this.motor.stopMotor();
    }
}
