package com.hades_region.blockchain.net.base;

/**
 * @author Robert Gerard
 * @since 2018-04-19 下午10:13.
 */
public class ServerResponseVo {

	private Object item;
	private boolean success = false;
	private String message;

	public ServerResponseVo() {
	}

	public ServerResponseVo(Object item, boolean status) {
		this.item = item;
		this.success = status;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
