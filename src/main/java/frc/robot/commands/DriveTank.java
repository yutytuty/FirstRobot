//// Copyright (c) FIRST and other WPILib contributors.
//// Open Source Software; you can modify and/or share it under the terms of
//// the WPILib BSD license file in the root directory of this project.
//
//package frc.robot.commands;
//
//import frc.robot.subsystems.DriveTrain;
//import edu.wpi.first.wpilibj2.command.CommandBase;
//
//import java.util.function.Supplier;
//
///**
// * An example command that uses an example subsystem.
// */
//public class DriveTank extends CommandBase {
//    private final DriveTrain drive;
//    Supplier<Double> rightSpeed, leftSpeed;
//
//    public DriveTank(DriveTrain drive, Supplier<Double> rightSpeed, Supplier<Double> leftSpeed) {
//        // Use addRequirements() here to declare subsystem dependencies.
//        this.drive = drive;
//        this.rightSpeed = rightSpeed;
//        this.leftSpeed = leftSpeed;
//
//        addRequirements(drive);
//    }
//
//
//    // Called every time the scheduler runs while the command is scheduled.
//    @Override
//    public void execute() {
//        this.drive.move(this.rightSpeed.get() * 0.5, this.leftSpeed.get() * 0.5);
//    }
//
//    // Called once the command ends or is interrupted.
//    @Override
//    public void end(boolean interrupted) {
//        this.drive.stop();
//    }
//
//    // Returns true when the command should end.
//    @Override
//    public boolean isFinished() {
//        return false;
//    }
//}
