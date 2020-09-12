package au.com.mir

data class Orders(val request: String) {
    fun getOrderType(): String {
        return request.split(':')[0]
    }

    fun getOrderDetails(): String {
        return request.split(':')[1]
    }
}
