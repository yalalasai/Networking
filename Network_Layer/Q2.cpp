#include <iostream>
#include <vector>

using namespace std;

int binTodec(int bits)
{
    int dec = 0, power = 128;
    while(bits > 0)
    {
        dec = dec + power;
        power /= 2;
        bits--;
    }
    return dec;
}

int main()
{
    cout << "Enter the IP address : ";
    int arr[4], i, prefix_length, First_Address[4], Last_Address[4], Not_Mask[4];

    for(i = 0; i < 4; i++)
        cin >> arr[i];
    
    cin >> prefix_length;

    int var;
    int mask[4];
    var = prefix_length / 8;

    if(var == 0)
    {
        mask[0] = binTodec(prefix_length % 8);
        for(i = 1; i < 4; i++)
            mask[i] = 0;
    }
    else if(var == 1)
    {
        mask[0] = 255;
        mask[1] = binTodec(prefix_length % 8);
        mask[2] = 0;
        mask[3] = 0;
    }
    else if(var== 2)
    {
        mask[0] = 255;
        mask[1] = 255;
        mask[2] = binTodec(prefix_length % 8);
        mask[3] = 0;
    }
    else if(var == 3)
    {
        mask[0] = 255;
        mask[1] = 255;
        mask[2] = 255;
        mask[3] = binTodec(prefix_length % 8);
    }
    else
    {
        mask[0] = 255;
        mask[1] = 255;
        mask[2] = 255;
        mask[3] = 255;
    }
    for(i = 0; i < 4; i++)
    {
        First_Address[i] = (arr[i] & mask[i]);
        cout << First_Address[i] << " "; 
        Not_Mask[i] = 255 - mask[i];
    }
    cout << endl;
    for(i = 0; i < 4; i++)
    {
        Last_Address[i] = (arr[i] | Not_Mask[i]);
        cout << Last_Address[i] << " ";
    }
}