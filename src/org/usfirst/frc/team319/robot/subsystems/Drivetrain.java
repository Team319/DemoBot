package org.usfirst.frc.team319.robot.subsystems;

import org.usfirst.frc.team319.models.BobTalonSRX;
import org.usfirst.frc.team319.models.DriveSignal;
import org.usfirst.frc.team319.models.LeaderBobTalonSRX;
import org.usfirst.frc.team319.models.SRXGains;
import org.usfirst.frc.team319.robot.commands.drivetrain.BobDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private boolean isHighGear = true;

	public LeaderBobTalonSRX leftLead = new LeaderBobTalonSRX(7, new BobTalonSRX(8)); //
	public LeaderBobTalonSRX rightLead = new LeaderBobTalonSRX(3, new BobTalonSRX(2)); //


	public Drivetrain() {

		// These Values will be different for every Robot :)
		leftLead.setInverted(true);
		leftLead.configPrimaryFeedbackDevice(FeedbackDevice.CTRE_MagEncoder_Relative);
		leftLead.setSensorPhase(false);

		rightLead.setInverted(false);
		rightLead.configPrimaryFeedbackDevice(FeedbackDevice.CTRE_MagEncoder_Relative);
		rightLead.setSensorPhase(false);

		leftLead.enableCurrentLimit(false);
		leftLead.configContinuousCurrentLimit(0);
		rightLead.enableCurrentLimit(false);
		rightLead.configContinuousCurrentLimit(0);

		leftLead.configOpenloopRamp(0.0);
		rightLead.configOpenloopRamp(0.0);

		setNeutralMode(NeutralMode.Coast);


	public void initDefaultCommand() {
		setDefaultCommand(new BobDrive());
	}


	public void drive(ControlMode controlMode, double left, double right) {
		this.leftLead.set(controlMode, left);
		this.rightLead.set(controlMode, right);
	} 

	public void drive(ControlMode controlMode, DriveSignal driveSignal) {
		this.drive(controlMode, driveSignal.getLeft(), driveSignal.getRight());
	}

	public double getLeftDriveLeadDistance() {
		return this.leftLead.getSelectedSensorPosition();
	}

	public double getRightDriveLeadDistance() {
		return this.rightLead.getSelectedSensorPosition();
	}

	public double getLeftDriveLeadVelocity() {
		return this.leftLead.getSelectedSensorVelocity();
	}

	public double getRightDriveLeadVelocity() {
		return this.rightLead.getSelectedSensorVelocity();
	}

	public void setDrivetrainPositionToZero() {
		this.leftLead.setSelectedSensorPosition(0);
		this.rightLead.setSelectedSensorPosition(0);
	}

	public double getLeftLeadVoltage() {
		return this.leftLead.getMotorOutputVoltage();
	}

	public double getRightLeadVoltage() {
		return this.rightLead.getMotorOutputVoltage();
	}

	public double getLeftClosedLoopError() {
		return this.leftLead.getClosedLoopError();
	}

	public double getRightClosedLoopError() {
		return this.rightLead.getClosedLoopError();
	}

	public TalonSRX getLeftLeadTalon() {
		return this.getLeftLeadTalon();
	}

	public TalonSRX getRightLeadTalon() {
		return this.rightLead;
	}

	public void setNeutralMode(NeutralMode neutralMode) {
		this.leftLead.setNeutralMode(neutralMode);
		this.rightLead.setNeutralMode(neutralMode);
	}

	public boolean isHighGear() {
		return isHighGear;
	}

	public void setIsHighGear(boolean isHighGear) {
		this.isHighGear = isHighGear;
	}


	public double getDistance() {
		return rightLead.getPrimarySensorPosition();
	}

	public double getVelocity() {
		return rightLead.getPrimarySensorVelocity();
	}

	@Override
	public void periodic() {
	}
}
