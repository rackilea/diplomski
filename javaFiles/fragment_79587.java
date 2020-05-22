//decryption
import CryptoJS from 'crypto-js';

const key = "somekeysomekey+)";

const decryptParam = function(param) {
    const value = param ? param.replace(' ', '+') : param;
    if (_.isEmpty(value)) {
        return;
    }

    const hexKey = CryptoJS.enc.Hex.parse(new Buffer(key).toString('hex'));
    const decryptOpt = {mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Iso10126};
    const bytes = CryptoJS.AES.decrypt(value, hexKey, decryptOpt);

    return bytes.toString(CryptoJS.enc.Utf8);
};