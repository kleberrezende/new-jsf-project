
(function ($) {

    $.fn.phoneFormat = function ()
    {

        return this.each(function ()
        {

            var obj = $(this);
            var is_number = /[0-9]/;

            // skip everything that isn't a number
            // and also skip the left zeroes
            function to_numbers(str)
            {
                var formatted = '';
                for (var i = 0; i < (str.length); i++)
                {
                    char_ = str.charAt(i);
                    if (formatted.length == 0 && char_ == 0)
                        char_ = false;

                    if (char_ && char_.match(is_number))
                    {
                        if (formatted.length < 11)
                            formatted = formatted + char_;
                    }
                }

                return formatted;
            }

            // remove zeros a esquerda
            function remove_zeroes(str)
            {
                if (str.substr(0, 1) == "0") {
                    str = formatted.substr(1, formatted.length);
                }

                return str;
            }

            // format as phone
            function phone_format(str)
            {
                var formatted = remove_zeroes(to_numbers(str));
                var parte1, parte2, codarea;
                //12 3456 7890
                if (formatted.length >= 3 && formatted.length <= 6) {
                    codarea = formatted.substr(0, 2);
                    parte1 = formatted.substr(2, 4);
                    formatted = "(" + codarea + ") " + parte1;
                } else if (formatted.length >= 7 && formatted.length <= 10) {
                    codarea = formatted.substr(0, 2);
                    parte1 = formatted.substr(2, 4);
                    parte2 = formatted.substr(6, 4);
                    formatted = "(" + codarea + ") " + parte1 + "-" + parte2;
                } else if (formatted.length == 11) {
                    codarea = formatted.substr(0, 2);
                    parte1 = formatted.substr(2, 5);
                    parte2 = formatted.substr(7, 4);
                    formatted = "(" + codarea + ") " + parte1 + "-" + parte2;
                }

                return formatted;
            }

            // filter what user type (only numbers and functional keys)
            function key_check(e)
            {
                var code = (e.keyCode ? e.keyCode : e.which);
                var typed = String.fromCharCode(code);
                var functional = false;
                var str = obj.val();
                var newValue = phone_format(str + typed);

                // allow key numbers, 0 to 9
                if ((code >= 48 && code <= 57) || (code >= 96 && code <= 105))
                    functional = true;

                // check Backspace, Tab, Enter, Delete, and left/right arrows
                if (code == 8)
                    functional = true;
                if (code == 9)
                    functional = true;
                if (code == 13)
                    functional = true;
                if (code == 46)
                    functional = true;
                if (code == 37)
                    functional = true;
                if (code == 39)
                    functional = true;

                if (!functional)
                {
                    e.preventDefault();
                    e.stopPropagation();
                    if (str != newValue)
                        obj.val(newValue);
                }

            }

            // inster formatted price as a value of an input field
            function phone_it()
            {
                var str = obj.val();
                var price = phone_format(str);
                if (str != price)
                    obj.val(price);
            }

            // bind the actions
            $(this).bind('keydown', key_check);
            $(this).bind('keyup', phone_it);

            // If value has content
            if ($(this).val().length > 0)
            {
                phone_it();
            }
        });

    };

    $.fn.setSelection = function (selectionStart, selectionEnd) {
        if (this.lengh == 0)
            return this;
        input = this[0];

        if (input.createTextRange) {
            var range = input.createTextRange();
            range.collapse(true);
            range.moveEnd('character', selectionEnd);
            range.moveStart('character', selectionStart);
            range.select();
        } else if (input.setSelectionRange) {
            input.focus();
            input.setSelectionRange(selectionStart, selectionEnd);
        }

        return this;
    };

})(jQuery);