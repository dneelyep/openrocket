package net.sf.openrocket.android.thrustcurve;

import java.util.HashMap;
import java.util.Map;


public class DownloadResponse {

	private Map<Integer,MotorBurnFile> data = new HashMap<Integer,MotorBurnFile>();
	
	private String error = null;
	
	public void add( MotorBurnFile mbd ) {
		MotorBurnFile currentData = data.get(mbd.getMotorId());
		if ( currentData == null || currentData.getDatapoints().size() < mbd.getDatapoints().size() ) {
			data.put(mbd.getMotorId(),mbd);
		}
	}

	public MotorBurnFile getData(Integer motor_id) {
		return data.get(motor_id);
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}
	
	@Override
	public String toString() {
		return "DownloadResponse [error=" + error + ", data=" + data + "]";
	}

}