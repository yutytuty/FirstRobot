// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveTank;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShootSystem;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {


    private Command m_autonomousCommand;

    private DriveTank driveTank;
    private DriveTrain driveTrain;
    private OI oi;
    private ShootSystem shootSystem;
    public ShootCommand shootCommand;

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        this.oi = new OI();
        this.driveTrain = new DriveTrain(new WPI_TalonSRX(RobotMap.CAN.rightTalon), new WPI_TalonSRX(RobotMap.CAN.leftTalon), new VictorSP(RobotMap.PWM.rightVictor), new VictorSP(RobotMap.PWM.leftVictor));
        this.driveTank = new DriveTank(this.driveTrain, oi::getRightY, oi::getLeftY);
        this.shootSystem = new ShootSystem(new WPI_TalonSRX(RobotMap.CAN.shootTalon), new WPI_VictorSPX(RobotMap.PWM.shootVictor));
        driveTrain.setDefaultCommand(this.driveTank);
    }


    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {

        // schedule the autonomous command (example)
        if (m_autonomousCommand != null) {
            m_autonomousCommand.schedule();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
