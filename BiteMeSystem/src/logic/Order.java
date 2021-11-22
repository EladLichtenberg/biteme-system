package logic;

public class Order {

	private String Restaurant, OrderNumber, OrderTime, PhoneNumber, TypeOfOrder, OrderAddress;

	/**
	 * @param restaurant
	 * @param orderNumber
	 * @param orderTime
	 * @param phoneNumber
	 * @param typeOfOrder
	 * @param orderAddress
	 */
	public Order(String restaurant, String orderNumber, String orderTime, String phoneNumber, String typeOfOrder,
			String orderAddress) {
		super();
		Restaurant = restaurant;
		OrderNumber = orderNumber;
		OrderTime = orderTime;
		PhoneNumber = phoneNumber;
		TypeOfOrder = typeOfOrder;
		OrderAddress = orderAddress;
	}

	public String getRestaurant() {
		return Restaurant;
	}

	public void setRestaurant(String restaurant) {
		Restaurant = restaurant;
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public String getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getTypeOfOrder() {
		return TypeOfOrder;
	}

	public void setTypeOfOrder(String typeOfOrder) {
		TypeOfOrder = typeOfOrder;
	}

	public String getOrderAddress() {
		return OrderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		OrderAddress = orderAddress;
	}

	public String toString() {
		return String.format("%s %s %s %s %s %s\n", Restaurant, OrderNumber, OrderTime, PhoneNumber, TypeOfOrder,
				OrderAddress);
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((OrderAddress == null) ? 0 : OrderAddress.hashCode());
//		result = prime * result + ((OrderNumber == null) ? 0 : OrderNumber.hashCode());
//		result = prime * result + ((OrderTime == null) ? 0 : OrderTime.hashCode());
//		result = prime * result + ((PhoneNumber == null) ? 0 : PhoneNumber.hashCode());
//		result = prime * result + ((Restaurant == null) ? 0 : Restaurant.hashCode());
//		result = prime * result + ((TypeOfOrder == null) ? 0 : TypeOfOrder.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (OrderAddress == null) {
			if (other.OrderAddress != null)
				return false;
		} else if (!OrderAddress.equals(other.OrderAddress))
			return false;
		if (OrderNumber == null) {
			if (other.OrderNumber != null)
				return false;
		} else if (!OrderNumber.equals(other.OrderNumber))
			return false;
		if (OrderTime == null) {
			if (other.OrderTime != null)
				return false;
		} else if (!OrderTime.equals(other.OrderTime))
			return false;
		if (PhoneNumber == null) {
			if (other.PhoneNumber != null)
				return false;
		} else if (!PhoneNumber.equals(other.PhoneNumber))
			return false;
		if (Restaurant == null) {
			if (other.Restaurant != null)
				return false;
		} else if (!Restaurant.equals(other.Restaurant))
			return false;
		if (TypeOfOrder == null) {
			if (other.TypeOfOrder != null)
				return false;
		} else if (!TypeOfOrder.equals(other.TypeOfOrder))
			return false;
		return true;
	}

}
