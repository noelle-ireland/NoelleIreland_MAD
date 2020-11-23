package com.example.lab8

data class IceCreamShop(var name:String="", var url:String="" ) {
    fun suggestIceCreamFlavor(position:Int){
        setIceCreamFlavor(position)
        setIceCreamUrl(position)
    }

    private fun setIceCreamFlavor(position: Int){
        when(position){
            0 -> name="Lemon Sorbet"
            1 -> name="Cookies and Cream"
            2 -> name="Dutch Chocolate"
            else -> name="Ice cream flavor of your choice"
        }
    }

    private fun setIceCreamUrl(position: Int){
        when(position) {
            0 -> url = "https://www.sweetcowicecream.com/nobo/"
            1 -> url = "https://www.sweetcowicecream.com/sobo/"
            2 -> url = "https://www.sweetcowicecream.com/louisville/"
            else -> url = "https://www.sweetcowicecream.com/"
        }
    }
}