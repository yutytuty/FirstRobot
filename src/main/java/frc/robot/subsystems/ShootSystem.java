package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootSystem extends SubsystemBase {
    private final WPI_TalonSRX motor1;
    private final WPI_VictorSPX motor2;

    public ShootSystem(WPI_TalonSRX motor1, WPI_VictorSPX motor2) {
        this.motor1 = motor1;
        this.motor2 = motor2;
    }
    public void on(double speed) {
        this.motor1.set(speed);
        this.motor2.set(speed);
    }

    public void off() {
        this.motor1.stopMotor();
        this.motor2.stopMotor();
    }
}
