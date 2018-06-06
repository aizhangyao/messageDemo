package entity;

/**  
 * @author zy  
 * @date 2018年5月28日  
 * @version 1.0  
 */
public class Order {
	private Integer id;
	private Integer state;//订单状态
	
	public Order() {
		super();
	}
	
	public Order(Integer state) {
		super();
		this.state = state;
	}

	public Order(Integer id, Integer state) {
		super();
		this.id = id;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", state=" + state + "]";
	}
	
	
}
