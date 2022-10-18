import android.text.method.PasswordTransformationMethod
import android.view.View

class CustomPassword : PasswordTransformationMethod() {
    override fun getTransformation(source: CharSequence?, view: View?): CharSequence {
        return PasswordCharSequence(source)
    }

    class PasswordCharSequence(source: CharSequence?) : CharSequence{
        val mSource = source
        override val length: Int = source!!.length

        override fun get(index: Int): Char {
            return '*'
        }

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
            return  mSource!!.subSequence(startIndex, endIndex)
        }
    }
}