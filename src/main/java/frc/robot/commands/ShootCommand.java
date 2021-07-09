package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSystem;

public class ShootCommand extends CommandBase {
    private final ShootSystem shoot;
    private final double speed = 0.7;


    public ShootCommand(ShootSystem shoot) {
        this.shoot = shoot;

        addRequirements(shoot);
    }

    @Override
    public void execute() {
        this.shoot.on(speed);
    }

    @Override
    public void end(boolean interrupted) {
        this.shoot.off();
    }
}
