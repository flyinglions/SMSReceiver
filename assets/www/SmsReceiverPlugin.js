var SmsReceiverPlugin = function()
{}

SmsReceiverPlugin.prototype.register = function(eventCallback, successCallback, failureCallback)
{
	
    return PhoneGap.exec(successCallback, failureCallback, 'SmsReceiverPlugin', 'register',
    		[{callback : eventCallback}]);
}


SmsReceiverPlugin.prototype.unregister = function( successCallback, failureCallback )
{
    return PhoneGap.exec(successCallback, failureCallback, 'SmsReceiverPlugin', 'unregister', [{}]); 
};

PhoneGap.addConstructor(function()
{
	//Register the javascript plugin with PhoneGap
	PhoneGap.addPlugin('SmsReceiverPlugin', new SmsReceiverPlugin());
});