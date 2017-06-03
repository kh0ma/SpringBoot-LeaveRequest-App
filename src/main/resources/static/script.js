/**
 * Created by kh0ma on 02.06.17.
 */

var ajaxUrl = '/ajax/leaverequest'

function add() {
    var date_start = $('#date_start').val();
    var date_end = $('#date_end').val();

    if( !(date_end  .match(/(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2})/g))  ||
        !(date_start.match(/(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2})/g))  ||
        !(date_end.length == 16) || !(date_start.length == 16))  {
        alert('Please input correct values!');
    }
    else {
        $.ajax({
            dataType: "json",
            type: "POST",
            url: ajaxUrl,
            contentType: "application/json",
            data: JSON.stringify({
                "dateStart" : date_start.replace(" ","T"),
                "dateEnd"   : date_end  .replace(" ","T")
            }),
            complete: function () {
                render();
            }
        });
    }


}

function render() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: ajaxUrl,
        data: null,
        success: function(data) {
            $("#render").empty();
            $.each(data, function(_, val) {
                $("#render").prepend("<p> id = "+val["id"]
                        +" Days between = "
                        + val["countDays"]+"</p>");
            });
        }
    });

}

/* OnPageLoad */
$(function () {
    $('#add_button').click(function() {
        add();
    });

    $('#date_end').datetimepicker({
        format:'Y-m-d H:i'
    });

    $('#date_start').datetimepicker({
        format:'Y-m-d H:i'
    });
});