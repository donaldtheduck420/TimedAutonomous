/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class TimedPath extends Command {

  public static Timer m_timer = new Timer();

  public TimedPath() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_drive);
    
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (m_timer.get() < 15.0){
      Robot.m_drive.tankDrive(0.5, 0.5);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (m_timer.get() >= 15.0) {
      return true;
    } 
    else {return false;}
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drive.tankDrive(0, 0);
    m_timer.reset();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
