package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private final WPI_TalonSRX frontRight;
    private final WPI_TalonSRX frontLeft;
    private final VictorSP rearRight;
    private final VictorSP rearLeft;

    public DriveTrain(WPI_TalonSRX frontRight, WPI_TalonSRX frontLeft, VictorSP rearRight, VictorSP rearLeft) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
        this.frontLeft.setInverted(true);
        this.rearLeft.setInverted(true);
    }

    public void move(double rightSpeed, double leftSpeed) {
        this.frontRight.set(rightSpeed);
        this.frontLeft.set(leftSpeed);
        this.rearRight.set(rightSpeed);
        this.rearLeft.set(leftSpeed);
    }

    public void stop() {
        this.frontLeft.stopMotor();
        this.frontRight.stopMotor();
        this.rearLeft.stopMotor();
        this.rearRight.stopMotor();
    }
}
