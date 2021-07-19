package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GenericShooter;

public class GenericShooterCommand extends CommandBase {
    private final GenericShooter motorSubsystem;
    private static final double SPEED = 0.7;

    public GenericShooterCommand(GenericShooter motorSubsystem) {
        addRequirements(motorSubsystem);

        this.motorSubsystem = motorSubsystem;
    }

    @Override
    public void execute() { motorSubsystem.on(SPEED); }

    @Override
    public void end(boolean interrupted) { motorSubsystem.off(); }

    @Override
    public boolean isFinished() { return false; }
}
