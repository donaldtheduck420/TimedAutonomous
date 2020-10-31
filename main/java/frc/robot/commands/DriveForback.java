/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class DriveForback extends Command { 
  //DRIVEFORBACK IS A COMMAND THAT CAN BE USED TO MAKE THE ROBOT DRIVE FORWARDS OR BACKWARDS

  private double motorPow;
  private double distance;
  
  public DriveForback(double motorPow, double distance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.motorPow = motorPow;
    this.distance = distance;
    requires(Robot.m_drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_drive.resetEncoders();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_drive.tankDrive(motorPow, motorPow);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.m_drive.returnDistance() < distance){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drive.tankDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_drive.tankDrive(0, 0);
  }
}
