package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.ShootSystem;

public class OI {
    private final Joystick left = new Joystick(0);
    private final Joystick right = new Joystick(1);

    public double getRightY() {
        return right.getY();
    }

    public double getLeftY() {
        return left.getY();
    }

    public OI() {
        Button shootButton=new JoystickButton(left,5);
        shootButton.whileHeld(new ShootCommand(new ShootSystem(new WPI_TalonSRX(RobotMap.CAN.shootTalon), new WPI_VictorSPX(RobotMap.PWM.shootVictor))));
    }
}
