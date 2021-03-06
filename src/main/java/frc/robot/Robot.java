// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.spikes2212.dashboard.ChildNamespace;
import com.spikes2212.dashboard.Namespace;
import com.spikes2212.dashboard.RootNamespace;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.GenericShooterCommand;
import frc.robot.subsystems.GenericShooter;
//import frc.robot.commands.DriveTank;
//import frc.robot.subsystems.DriveTrain;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {


    private Command m_autonomousCommand;

    RootNamespace namespace;

    private static WPI_TalonSRX shootSystemTalon;
    private static WPI_VictorSPX shootSystemVictor;


    private static void setSpeed() {
        shootSystemVictor.set(0.5);
        shootSystemTalon.set(0.5);
    }

    private static void stop() {
        shootSystemTalon.stopMotor();
        shootSystemVictor.stopMotor();
    }

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        shootSystemTalon = new WPI_TalonSRX(RobotMap.CAN.shootTalon);
        shootSystemVictor = new WPI_VictorSPX(RobotMap.PWM.shootVictor);
        namespace = new RootNamespace("Robot");
        Namespace shootSystemNameSpace = namespace.addChild("ShootSystemNamespace");
        shootSystemNameSpace.putData("stop", new InstantCommand(Robot::stop));
        shootSystemNameSpace.putData("Test", new InstantCommand(Robot::setSpeed));

    }


    @Override
    public void robotPeriodic() {
        namespace.update();
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
